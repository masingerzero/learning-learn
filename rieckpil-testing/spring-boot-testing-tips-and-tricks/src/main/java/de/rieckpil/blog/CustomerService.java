package de.rieckpil.blog;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }
  public Long register(String customerId) {
    System.out.println("Registering customer with id: " + customerId);
    //added by my

    Customer customer = customerRepository.findByCustomerId(customerId);
    customer.setId(customerId);
    return customer.getId();
//    return 42L; // made by my the commenting this line
  }
}
