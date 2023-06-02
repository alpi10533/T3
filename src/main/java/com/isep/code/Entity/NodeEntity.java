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
@Table(name = "node")
public class NodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_node")
    private Long idNode;

    @OneToOne
    @JoinColumn(name = "id_place")
    private PlaceEntity place;

    @OneToMany(mappedBy = "nodeEntity", cascade = CascadeType.ALL)
    private Set<EdgeEntity> edgeEntities;

}
