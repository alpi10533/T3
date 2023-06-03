package com.isep.code.Repository;

import com.isep.code.Entity.DefaultEntity;
import com.isep.code.Entity.GraphEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultRepository extends JpaRepository<DefaultEntity, Long> {

    @Query("select u from DefaultEntity u where u.travelMode = :x")
    DefaultEntity findByTravelMode(@Param("x") int travelMode);

    @Modifying
    @Query("delete from DefaultEntity u where u.graph = :x")
    void deleteAllByGraph(@Param("x") GraphEntity graph);

}