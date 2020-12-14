package com.dyhnhqns.repository;

import com.dyhnhqns.model.PulsaXL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PulsaXLRepository  extends JpaRepository<PulsaXL, String> {
}
