package com.isep.code.Repository;

import com.isep.code.Entity.EdgeEntity;
import com.isep.code.Entity.GraphEntity;
import com.isep.code.Entity.NodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GraphRepository extends JpaRepository<GraphEntity, Long> {

    @Query("select u from EdgeEntity u where u.graph = :x and u.source = :y")
    Set<EdgeEntity> findAllEdgesByGraphAndNode(@Param("x") GraphEntity graph, @Param("y") NodeEntity start);

    @Query("select u from EdgeEntity u where u.graph = :x")
    Set<EdgeEntity> findAllEdgesByGraph(@Param("x") GraphEntity graph);

}