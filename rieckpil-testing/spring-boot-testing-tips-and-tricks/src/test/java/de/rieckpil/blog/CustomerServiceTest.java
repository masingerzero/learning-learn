package de.rieckpil.blog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerService customerService;


    @Test
    void loadContext() {
        Customer customer = new Customer("John", "Larson");
        customer.setId("1111");
        Mockito.when(customerRepository.findByCustomerId("1111"))
                .thenReturn(customer);
        Long id = customerService.register("1111");
        Assertions.assertEquals(1111, id);
    }
}
