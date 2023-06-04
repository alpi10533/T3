package com.isep.code.Repository;

import com.isep.code.Entity.NodeEntity;
import com.isep.code.Entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<NodeEntity, Long> {

    @Query("select u from NodeEntity u where u.place = :x")
    NodeEntity findByPlace(@Param("x") PlaceEntity place);

}