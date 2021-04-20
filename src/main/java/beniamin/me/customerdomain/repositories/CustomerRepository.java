package beniamin.me.customerdomain.repositories;

import beniamin.me.customerdomain.entities.Customer;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {


  List<Customer> findByEmailAndName(String email, String name);

  List<Customer> findByEmailLike(String desc);

  List<Customer> findByIdIn(List<Integer> ids);

  @Modifying
  @Query("update Customer set email=:newEmail where id=:id and email=:email")
  void updateStudentEmail(@Param("newEmail") String newEmail, @Param("id") int id,
      @Param("email") String email);

  @Query("from Customer")
  List<Customer> findAllCustomers(Pageable pageable);

}
