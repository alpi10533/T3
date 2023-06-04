package com.isep.code.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "node")
public class NodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_node", unique = true, nullable = false)
    private Long idNode;

    @OneToOne
    @JoinColumn(name = "id_place")
    private PlaceEntity place;

    @OneToMany(mappedBy = "source", cascade = CascadeType.MERGE)
    @JsonBackReference
    private Set<EdgeEntity> sources;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.MERGE)
    @JsonBackReference
    private Set<EdgeEntity> destinations;

}
