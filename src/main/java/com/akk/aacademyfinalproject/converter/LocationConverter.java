package com.akk.aacademyfinalproject.converter;

import com.akk.aacademyfinalproject.dto.LocationDto;
import com.akk.aacademyfinalproject.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter {

    public LocationDto toLocationDto(Location location){
        return LocationDto.builder()
                .locName(location.getLocName())
                .build();
    }

    public Location toLocation(LocationDto locationDto){
        return Location.builder()
                .locName(locationDto.getLocName())
                .build();
    }
}
