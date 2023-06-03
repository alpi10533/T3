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
@Table(name = "default_")
public class DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_default_", unique = true, nullable = false)
    private Long idDefault;

    @ManyToOne
    @JoinColumn(name = "id_graph")
    private GraphEntity graph;

    @Column(name = "travelMode")
    private int travelMode;

}
