package com.isep.code.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "edge")
public class EdgeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_edge")
    private Long idEdge;

    @ManyToOne
    @JoinColumn(name = "id_source")
    private NodeEntity source;

    @ManyToOne
    @JoinColumn(name = "id_destination")
    private NodeEntity destination;

    @Column(name = "weight", nullable = false)
    private double weight;

    @ManyToOne
    @JoinColumn(name = "id_graph")
    private GraphEntity graphEntity;

}
