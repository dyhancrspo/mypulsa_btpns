package com.dyhnhqns.repository;

import com.dyhnhqns.model.PulsaTelkomsel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PulsaTelkomselRepository extends JpaRepository<PulsaTelkomsel, String> {

}
