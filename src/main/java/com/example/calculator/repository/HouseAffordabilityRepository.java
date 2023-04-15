package com.example.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.calculator.entity.HouseAffordability;

@Repository
public interface HouseAffordabilityRepository extends JpaRepository<HouseAffordability, Long> {
	HouseAffordability findById(long id);
}
