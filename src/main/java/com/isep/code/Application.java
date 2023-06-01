package com.isep.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.DayOfWeek;
import java.time.LocalTime;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        PlaceService placeService = ctx.getBean(PlaceService.class);
        placeService.savePlace("La tour Eiffel", "Monument", 48.85856768770539, 2.2944813100320407, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(0, 45, 0), 26.80);
        placeService.savePlace("Musée du Louvre", "Musée", 48.86074515198898, 2.337686922353146, DayOfWeek.WEDNESDAY, DayOfWeek.MONDAY, LocalTime.of(9, 0, 0), LocalTime.of(18, 0, 0), 17.00);
        placeService.savePlace("Conciergerie", "Monument", 48.85672575971245, 2.3458212625352495, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 30, 0), LocalTime.of(18, 30, 0), 11.50);
        placeService.savePlace("Centre Pompidou", "Musée", 48.86075487756134, 2.3522450056486073, DayOfWeek.WEDNESDAY, DayOfWeek.MONDAY, LocalTime.of(9, 0, 0), LocalTime.of(18, 0, 0), 15.00);
        placeService.savePlace("Sainte-Chapelle", "Monument", 48.85545259381476, 2.344950174936974, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0), 11.50);
        placeService.savePlace("Musée d Orsay", "Musée", 48.86006016298918, 2.3265184893450637, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0), 16.00);
        placeService.savePlace("Fondation Louis Vuitton", "Musée", 48.87673697222163, 2.2635560912352983, DayOfWeek.WEDNESDAY, DayOfWeek.MONDAY, LocalTime.of(10, 0, 0), LocalTime.of(20, 0, 0), 9.00);
        placeService.savePlace("Panthéon", "Monument", 48.84628528613142, 2.3464459897583825, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0), 11.50);
        placeService.savePlace("Arc de Triomphe", "Monument", 48.87393983078349, 2.2950275074751576, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(23, 0, 0), 13.00);
        placeService.savePlace("Musée du quai Branly", "Musée", 48.86091001832707, 2.2978725431611453, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 30, 0), LocalTime.of(19, 0, 0), 12.00);
        placeService.savePlace("Institut du monde arabe", "Musée", 48.84896094211493, 2.357274217166676, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(13, 0, 0), LocalTime.of(18, 0, 0), 8.00);
        placeService.savePlace("Musée Rodin", "Musée", 48.85543420797071, 2.315835406378667, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(18, 30, 0), 12.00);
        placeService.savePlace("Musée de Cluny", "Musée", 48.85063855966835, 2.344080807837426, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 30, 0), LocalTime.of(18, 15, 0), 12.00);
        placeService.savePlace("Grand Palais", "Musée", 48.85344579098905, 2.302410265281665, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(20, 0, 0), 10.00);
        placeService.savePlace("Petit Palais", "Musée", 48.866118418876425, 2.314611061238636, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0), 0.00);
        placeService.savePlace("Hotel de Béthune-Sully", "Monument", 48.85532458336893, 2.364427008194676, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(19, 0, 0), 0.00);
        placeService.savePlace("Basilique du Sacré-Coeur de Montmartre", "Lieu de culte", 48.88685974869238, 2.3430399344103514, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(6, 0, 0), LocalTime.of(22, 30, 0), 0.00);
        placeService.savePlace("Avenue des Champs-Élysées", "Quartier d'intérêt", 48.87306599448159, 2.297788231917454, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(0, 0, 0), LocalTime.of(23, 59, 0), 0.00);
        placeService.savePlace("Tour Saint-Jacques", "Monument", 48.85818844193142, 2.3489179349124143, DayOfWeek.FRIDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0), 12.00);
        placeService.savePlace("Île de la Cité", "Quartier d'intérêt", 48.85525355220592, 2.3468695876488757, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(0, 0, 0), LocalTime.of(23, 59, 0), 0.00);
        placeService.savePlace("Cathédrale de la Sainte-Trinité", "Lieu de culte", 48.86212267391677, 2.300997881117963, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(14, 0, 0), LocalTime.of(19, 0, 0), 0.00);
        placeService.savePlace("Place de la Concorde", "Quartier d'intérêt", 48.86569656101774, 2.321289347534348, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(0, 0, 0), LocalTime.of(23, 59, 0), 0.00);
        placeService.savePlace("Tour Jean-sans-Peur", "Monument", 48.86435037479113, 2.348041643521805, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY, LocalTime.of(13, 30, 0), LocalTime.of(18, 0, 0), 6.00);
        placeService.savePlace("Arènes de Lutèce", "Monument", 48.84524303335598, 2.3528580641779517, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(19, 0, 0), 0.00);
        placeService.savePlace("Palais de Tokyo", "Musée", 48.86461592834268, 2.2966407453267044, DayOfWeek.WEDNESDAY, DayOfWeek.MONDAY, LocalTime.of(12, 0, 0), LocalTime.of(21, 0, 0), 12.00);
        placeService.savePlace("Passage Brady", "Quartier d'intérêt", 48.871540502219624, 2.355119694411343, DayOfWeek.MONDAY, DayOfWeek.SATURDAY, LocalTime.of(9, 30, 0), LocalTime.of(23, 30, 0), 0.00);
        placeService.savePlace("Opéra national de Paris", "Monument", 48.8723068631308, 2.3316018265859415, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(17, 0, 0), 14.00);
        placeService.savePlace("Cimetière du Père Lachaise", "Quartier d'intérêt", 48.861521349900606, 2.393515417905678, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(8, 30, 0), LocalTime.of(17, 30, 0), 0.00);
        placeService.savePlace("Observatoire Paris Montparnasse", "Monument", 48.84220928620018, 2.321961579713815, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 30, 0), LocalTime.of(22, 30, 0), 20.00);
    }

}
