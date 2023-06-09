package com.isep.code.Repository;

import com.isep.code.Entity.EdgeEntity;
import com.isep.code.Entity.GraphEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EdgeRepository extends JpaRepository<EdgeEntity, Long> {

    @Modifying
    @Query("delete from EdgeEntity u where u.graph = :x")
    void deleteAllByGraph(@Param("x") GraphEntity graph);

}