package com.isep.code.Repository;

import com.isep.code.Entity.CoordinateEntity;
import com.isep.code.Entity.EdgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateRepository extends JpaRepository<CoordinateEntity, Long> {
}