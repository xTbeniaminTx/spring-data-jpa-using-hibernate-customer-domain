package beniamin.me.customerdomain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import beniamin.me.customerdomain.entities.Customer;
import beniamin.me.customerdomain.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaUsingHibernateCustomerDomainApplicationTests {

  @Autowired
  CustomerRepository repository;
  
  @Test
  void contextLoads() {
  }

  @Test
  public void testCreate() {
    Customer customer = new Customer();
    customer.setId(1);
    customer.setName("Eugen");
    customer.setEmail("eugen@gmail.Com");

    repository.save(customer);
  }

  @Test
  public void testRead() {
    Customer customer = repository.findById(1).get();
    assertNotNull(customer);
    assertEquals("Eugen", customer.getName());
  }

  @Test
  public void testUpdate() {
    Customer customer = repository.findById(1).get();
    customer.setName("Eugenia");
    assertNotNull(customer);
    assertEquals("Eugenia", customer.getName());

    repository.save(customer);
  }

  @Test
  public void testDelete() {
    if (repository.existsById(1)) {
      System.out.println("Deleting a customer");
      repository.deleteById(1);
    }
  }

  @Test
  public void testCount() {
    System.out.println("<<<<<<<<<<<<<<<<COUNT>>>>>>>>>>>>>>>>> "+ repository.count());
  }

}
