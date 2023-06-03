package com.isep.code.Model;

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
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_place", unique = true, nullable = false)
    private Long idPlace;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "latitude", nullable = false)
    private String latitude;

    @Column(name = "longitude", nullable = false)
    private String longitude;

    @Column(name = "start_day", nullable = false)
    private String start_day;

    @Column(name = "end_day", nullable = false)
    private String end_day;

    @Column(name = "start_hour", nullable = false)
    private String start_hour;

    @Column(name = "end_hour", nullable = false)
    private String end_hour;

    @Column(name = "price", nullable = false)
    private String price;

}
