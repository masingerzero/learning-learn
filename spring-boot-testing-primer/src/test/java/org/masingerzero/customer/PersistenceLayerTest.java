package org.masingerzero.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.masingerzero.customer.Customer;
import org.masingerzero.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.ZonedDateTime;
import java.util.List;

@DataJpaTest
public class PersistenceLayerTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void dependenciesTest() {
        Assertions.assertNotNull(customerRepository);
        Assertions.assertNotNull(testEntityManager);
    }

    @Test
    public void addCustomerWithTestEntityManager() {
        Customer customer1 = new Customer("Tim", ZonedDateTime.now());
        Customer customer2 = new Customer("Lee", ZonedDateTime.now().minusDays(1));
        Long customer1Id = testEntityManager.persistAndGetId(customer1, Long.class);
        Long customer2Id = testEntityManager.persistAndGetId(customer2, Long.class);
        testEntityManager.flush();
        testEntityManager.clear();


        Customer retrievedCustomer1 = testEntityManager.find(Customer.class, customer1Id);
        Customer retrievedCustomer2 = testEntityManager.find(Customer.class, customer2Id);

        Assertions.assertEquals(customer1.getName(), retrievedCustomer1.getName());
        Assertions.assertEquals(customer2.getName(), retrievedCustomer2.getName());
    }

    @Test
    public void addCustomersWithCustomerRepositoryTest() {
        Customer customer1 = customerRepository.save(new Customer("Tim", ZonedDateTime.now()));
        Customer customer2 = customerRepository.save(new Customer("Lee", ZonedDateTime.now().minusDays(1)));
        customerRepository.flush();

        testEntityManager.clear();

        Customer retrievedCustomer1 = customerRepository.findById(customer1.getId()).get();
        Customer retrievedCustomer2 = customerRepository.findById(customer2.getId()).get();

        Assertions.assertEquals(customer1.getName(), retrievedCustomer1.getName());
        Assertions.assertEquals(customer2.getName(), retrievedCustomer2.getName());

    }

    @Test
    public void obtainEarliestJoinedCustomerTest() {
        Customer tim = new Customer("Tim", ZonedDateTime.now());
        Customer lee = new Customer("Lee", ZonedDateTime.now().minusDays(1));
        customerRepository.saveAllAndFlush(List.of(tim, lee));


        testEntityManager.clear();

        Customer earliestJoinedCustomer = customerRepository.findEarliestJoinedCustomer();

        Assertions.assertEquals("Lee", earliestJoinedCustomer.getName());

    }




}
