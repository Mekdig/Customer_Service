package org.zeetransportations.zeetransportations.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zeetransportations.zeetransportations.entity.Address;

@Repository
public interface AddressController extends JpaRepository<Address,Integer> {
}
