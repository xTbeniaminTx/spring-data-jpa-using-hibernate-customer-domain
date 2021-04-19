package beniamin.me.customerdomain.repositories;

import beniamin.me.customerdomain.entities.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {


  List<Customer> findByEmailAndName(String email, String name);

  List<Customer> findByEmailLike(String desc);

  List<Customer> findByIdIn(List<Integer> ids);

}
