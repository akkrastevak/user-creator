package com.akk.aacademyfinalproject.controller;

import com.akk.aacademyfinalproject.converter.LocationConverter;
import com.akk.aacademyfinalproject.dto.LocationDto;
import com.akk.aacademyfinalproject.entity.Location;
import com.akk.aacademyfinalproject.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    private final LocationService locationService;
    private final LocationConverter locationConverter;

    @Autowired
    public LocationController(LocationService locationService, LocationConverter locationConverter){
        this.locationService = locationService;
        this.locationConverter = locationConverter;
    }


}
