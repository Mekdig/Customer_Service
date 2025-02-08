package org.zeetransportations.zeetransportations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zeetransportations.zeetransportations.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer getCustomerById(Integer id);
}
