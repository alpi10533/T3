package com.isep.code.Repository;

import com.isep.code.Entity.GraphEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphRepository extends JpaRepository<GraphEntity, Long> {
}