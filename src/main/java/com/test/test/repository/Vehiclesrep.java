package com.test.test.repository;

import com.test.test.entity.Vehiclesent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Vehiclesrep  extends JpaRepository<Vehiclesent,Long> {
}
