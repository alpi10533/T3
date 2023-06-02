package com.isep.code.Service;

import com.isep.code.Entity.EdgeEntity;
import com.isep.code.Entity.NodeEntity;
import com.isep.code.Repository.EdgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdgeService {

    private final EdgeRepository edgeRepository;

    @Autowired
    public EdgeService(EdgeRepository edgeRepository) {
        this.edgeRepository = edgeRepository;
    }

    public void saveEdge(NodeEntity source, NodeEntity destination, double weight) {
        EdgeEntity edgeEntity = new EdgeEntity();
        edgeEntity.setSource(source);
        edgeEntity.setDestination(destination);
        edgeEntity.setWeight(weight);
        edgeRepository.save(edgeEntity);
    }

}