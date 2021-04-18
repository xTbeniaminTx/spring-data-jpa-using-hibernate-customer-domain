package beniamin.me.customerdomain.repositories;

import beniamin.me.customerdomain.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
