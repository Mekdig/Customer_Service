package org.zeetransportations.zeetransportations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zeetransportations.zeetransportations.entity.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead,Integer> {
}
