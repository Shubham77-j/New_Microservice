package com.propertyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propertyservice.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

	Area findByName(String name);

}
