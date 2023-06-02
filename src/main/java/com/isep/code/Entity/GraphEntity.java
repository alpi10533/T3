package com.isep.code.Entity;

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

    @OneToMany(mappedBy = "graph", cascade = CascadeType.MERGE)
    private Set<EdgeEntity> edges;

}
