package com.isep.code.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

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

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "start_day")
    DayOfWeek startDay;

    @Column(name = "end_day")
    DayOfWeek endDay;

    @Column(name = "start_hour")
    LocalTime startHour;

    @Column(name = "end_hour")
    LocalTime endHour;

    @Column(name = "price")
    private double price;

}

