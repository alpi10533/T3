package com.isep.code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isep.code.Model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}