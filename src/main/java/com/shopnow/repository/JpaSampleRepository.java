package com.shopnow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopnow.dto.JpaSampleDTO;
import com.shopnow.entity.JpaSample;

public interface JpaSampleRepository extends JpaRepository<JpaSample, Integer> {
	public List<JpaSample> findByFirstName(String firstNme);
	public List<JpaSample> findByLastName(String lastName);
	public JpaSample findFirstByEmail(String email);
}
