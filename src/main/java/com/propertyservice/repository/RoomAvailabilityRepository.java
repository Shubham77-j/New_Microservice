package com.propertyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertyservice.entity.RoomAvailability;

public interface RoomAvailabilityRepository extends JpaRepository<RoomAvailability, Long> {
	RoomAvailability findByRoomId(Long roomId);


}
