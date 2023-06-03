package com.isep.code.Service;

import com.isep.code.Entity.DefaultEntity;
import com.isep.code.Entity.GraphEntity;
import com.isep.code.Repository.DefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultService {

    private final DefaultRepository defaultRepository;

    @Autowired
    public DefaultService(DefaultRepository defaultRepository) {
        this.defaultRepository = defaultRepository;
    }

    public void saveDefault(GraphEntity graph, int travelMode) {
        DefaultEntity default_ = findDefaultByTravelMode(travelMode);
        if (default_ == null) {
            default_ = new DefaultEntity();
            default_.setTravelMode(travelMode);
        }
        default_.setGraph(graph);
        defaultRepository.save(default_);
    }

    public DefaultEntity findDefaultByTravelMode(int travelMode) {
        return defaultRepository.findByTravelMode(travelMode);
    }

    @Transactional
    public void deleteAllDefaultsByGraph(GraphEntity graph) {
        defaultRepository.deleteAllByGraph(graph);
    }

}