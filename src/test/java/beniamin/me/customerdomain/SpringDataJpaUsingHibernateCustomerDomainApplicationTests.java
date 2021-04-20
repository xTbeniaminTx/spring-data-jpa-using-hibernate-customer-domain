package beniamin.me.customerdomain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import beniamin.me.customerdomain.entities.Customer;
import beniamin.me.customerdomain.repositories.CustomerRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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
    System.out.println("<<<<<<<<<<<<<<<<COUNT>>>>>>>>>>>>>>>>> " + repository.count());
  }

  @Test
  public void findByEmailAndName() {
    List<Customer> customers = repository
        .findByEmailAndName("eugen@gmail.com", "eugen");
    customers.forEach(c -> System.out.println(
        "<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>> "
            + c.getName() + "   " + c.getEmail()
            + " <<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>"));
  }

  @Test
  public void findByDescLike() {
    List<Customer> customers = repository
        .findByEmailLike("%gmail%");
    customers.forEach(c -> System.out.println(
        "<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>> "
            + c.getEmail() + "   " + c.getName()
            + " <<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>"));
  }

  @Test
  public void findByIdsIn() {
    List<Customer> customers = repository
        .findByIdIn(Arrays.asList(1, 5, 3));
    customers.forEach(c -> System.out.println(
        "<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>> "
            + c.getEmail() + "   " + c.getName()
            + " <<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>"));
  }

  @Test
  @Transactional
  @Rollback(value = false)
  public void updateCustomerEmail() {
    repository.updateStudentEmail("mia.new@gmail.com", 5, "mia@gmail.com");
  }

}
