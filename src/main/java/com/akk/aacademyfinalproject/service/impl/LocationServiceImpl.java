package com.akk.aacademyfinalproject.service.impl;

import com.akk.aacademyfinalproject.entity.Location;
import com.akk.aacademyfinalproject.entity.User;
import com.akk.aacademyfinalproject.exeption.LocationNotFoundExeption;
import com.akk.aacademyfinalproject.repository.LocationRepository;
import com.akk.aacademyfinalproject.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @Override
    public Location findByLocationId(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(()-> new LocationNotFoundExeption(String.format("Location with that %s can't be found", id)));
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location update(Location location, Long id) {
        Location foundLocation = this.findByLocationId(id);
        Location updatedLocation = Location.builder()
                .id(foundLocation.getId())
                .locName(foundLocation.getLocName())
                .build();
        return locationRepository.save(updatedLocation);
    }
}
