package com.isep.code.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "place")
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_place", unique = true, nullable = false)
    private Long idPlace;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "start_day", nullable = false)
    DayOfWeek startDay;

    @Column(name = "end_day", nullable = false)
    DayOfWeek endDay;

    @Column(name = "start_hour", nullable = false)
    LocalTime startHour;

    @Column(name = "end_hour", nullable = false)
    LocalTime endHour;

    @Column(name = "price", nullable = false)
    private double price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coordinate", nullable = false)
    private CoordinateEntity coordinate;

}

