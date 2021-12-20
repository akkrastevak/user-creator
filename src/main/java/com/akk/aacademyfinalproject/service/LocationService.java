package com.akk.aacademyfinalproject.service;

import com.akk.aacademyfinalproject.entity.Location;
import com.akk.aacademyfinalproject.entity.User;

public interface LocationService {

    Location findByLocationId(Long id);

    Location save(Location location);

    Location update(Location location, Long id);
}
