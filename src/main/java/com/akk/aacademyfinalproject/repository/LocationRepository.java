package com.akk.aacademyfinalproject.repository;

import com.akk.aacademyfinalproject.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {


}
