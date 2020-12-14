package com.dyhnhqns.repository;

import com.dyhnhqns.model.PulsaIndosat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PulsaIndosatRepository extends JpaRepository<PulsaIndosat, String> {
}
