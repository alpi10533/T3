package com.isep.code.Service;

import com.isep.code.Entity.NodeEntity;
import com.isep.code.Entity.PlaceEntity;
import com.isep.code.Repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeService {

    private final NodeRepository nodeRepository;

    @Autowired
    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public void saveNode(PlaceEntity placeEntity) {
        NodeEntity nodeEntity = new NodeEntity();
        nodeEntity.setPlace(placeEntity);
        nodeRepository.save(nodeEntity);
    }

}