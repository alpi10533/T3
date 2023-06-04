package com.isep.code.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "graph")
public class GraphEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_graph", unique = true, nullable = false)
    private Long idGraph;

    @Column(name = "numberOfNeighbors")
    private int numberOfNeighbors;

    @Column(name = "travelMode")
    private int travelMode;

    @OneToMany(mappedBy = "graph", cascade = CascadeType.MERGE)
    @JsonManagedReference
    private Set<EdgeEntity> edges;

    @OneToMany(mappedBy = "graph", cascade = CascadeType.MERGE)
    @JsonManagedReference
    private Set<DefaultEntity> defaults;

}
