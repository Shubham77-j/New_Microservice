package com.propertyservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.propertyservice.dto.PropertyDto;
import com.propertyservice.entity.Area;
import com.propertyservice.entity.City;
import com.propertyservice.entity.Property;
import com.propertyservice.entity.State;
import com.propertyservice.repository.*; // Assuming your repositories are here

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomAvailabilityRepository availabilityRepository;

    public Property addProperty(PropertyDto dto, MultipartFile[] files) {
    	
    	 String cityName =dto.getCity();
    	 City city =cityRepository.findByName(cityName);
    	 
    	 String areaName =dto.getArea();
    	Area area =areaRepository.findByName(areaName);
         
         String stateName =dto.getState();
    	State state=stateRepository.findByName(stateName);
    	
    	Property property = new Property( );
    	property.setName(dto.getName( ));
    	property.setNumberOfBathrooms(dto.getNumberOfBathrooms( ));
    	property.setNumberOfBeds(dto.getNumberOfBeds( ));
    	property.setNumberOfRooms(dto.getNumberOfRooms( ));
    	property.setNumberOfGuestAllowed(dto.getNumberOfGuestAllowed());
    	property.setCity(city);
    	property.setArea(area);
    	property.setState(state);
    	
    	 Property savedProperty=propertyRepository.save(property);
    	

        return savedProperty;
    }
}
