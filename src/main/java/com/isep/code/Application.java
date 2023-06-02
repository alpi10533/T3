package com.isep.code;

import com.isep.code.Entity.CoordinateEntity;
import com.isep.code.Service.CoordinateService;
import com.isep.code.Service.GraphService;
import com.isep.code.Service.PlaceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.DayOfWeek;
import java.time.LocalTime;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        CoordinateService coordinateService = ctx.getBean(CoordinateService.class);
        PlaceService placeService = ctx.getBean(PlaceService.class);

        CoordinateEntity coordinateEntity1 = coordinateService.saveCoordinate(48.85856768770539, 2.2944813100320407);
        placeService.savePlace("La tour Eiffel", "Monument", coordinateEntity1, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(0, 45, 0), 26.80);

        CoordinateEntity coordinateEntity2 = coordinateService.saveCoordinate(48.86074515198898, 2.337686922353146);
        placeService.savePlace("Musée du Louvre", "Musée", coordinateEntity2, DayOfWeek.WEDNESDAY, DayOfWeek.MONDAY, LocalTime.of(9, 0, 0), LocalTime.of(18, 0, 0), 17.00);

        CoordinateEntity coordinateEntity3 = coordinateService.saveCoordinate(48.85672575971245, 2.3458212625352495);
        placeService.savePlace("Conciergerie", "Monument", coordinateEntity3, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 30, 0), LocalTime.of(18, 30, 0), 11.50);

        CoordinateEntity coordinateEntity4 = coordinateService.saveCoordinate(48.86075487756134, 2.3522450056486073);
        placeService.savePlace("Centre Pompidou", "Musée", coordinateEntity4, DayOfWeek.WEDNESDAY, DayOfWeek.MONDAY, LocalTime.of(9, 0, 0), LocalTime.of(18, 0, 0), 15.00);

        CoordinateEntity coordinateEntity5 = coordinateService.saveCoordinate(48.85545259381476, 2.344950174936974);
        placeService.savePlace("Sainte-Chapelle", "Monument", coordinateEntity5, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0), 11.50);

        CoordinateEntity coordinateEntity6 = coordinateService.saveCoordinate(48.86006016298918, 2.3265184893450637);
        placeService.savePlace("Musée d Orsay", "Musée", coordinateEntity6, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0), 16.00);

        CoordinateEntity coordinateEntity7 = coordinateService.saveCoordinate(48.87673697222163, 2.2635560912352983);
        placeService.savePlace("Fondation Louis Vuitton", "Musée", coordinateEntity7, DayOfWeek.WEDNESDAY, DayOfWeek.MONDAY, LocalTime.of(10, 0, 0), LocalTime.of(20, 0, 0), 9.00);

        CoordinateEntity coordinateEntity8 = coordinateService.saveCoordinate(48.84628528613142, 2.3464459897583825);
        placeService.savePlace("Panthéon", "Monument", coordinateEntity8, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0), 11.50);

        CoordinateEntity coordinateEntity9 = coordinateService.saveCoordinate(48.87393983078349, 2.2950275074751576);
        placeService.savePlace("Arc de Triomphe", "Monument", coordinateEntity9, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(23, 0, 0), 13.00);

        CoordinateEntity coordinateEntity10 = coordinateService.saveCoordinate(48.86091001832707, 2.2978725431611453);
        placeService.savePlace("Musée du quai Branly", "Musée", coordinateEntity10, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 30, 0), LocalTime.of(19, 0, 0), 12.00);

        CoordinateEntity coordinateEntity11 = coordinateService.saveCoordinate(48.84896094211493, 2.357274217166676);
        placeService.savePlace("Institut du monde arabe", "Musée", coordinateEntity11, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(13, 0, 0), LocalTime.of(18, 0, 0), 8.00);

        CoordinateEntity coordinateEntity12 = coordinateService.saveCoordinate(48.85543420797071, 2.315835406378667);
        placeService.savePlace("Musée Rodin", "Musée", coordinateEntity12, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(18, 30, 0), 12.00);

        CoordinateEntity coordinateEntity13 = coordinateService.saveCoordinate(48.85063855966835, 2.344080807837426);
        placeService.savePlace("Musée de Cluny", "Musée", coordinateEntity13, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 30, 0), LocalTime.of(18, 15, 0), 12.00);

        CoordinateEntity coordinateEntity14 = coordinateService.saveCoordinate(48.85344579098905, 2.302410265281665);
        placeService.savePlace("Grand Palais", "Musée", coordinateEntity14, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(20, 0, 0), 10.00);

        CoordinateEntity coordinateEntity15 = coordinateService.saveCoordinate(48.866118418876425, 2.314611061238636);
        placeService.savePlace("Petit Palais", "Musée", coordinateEntity15, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0), 0.00);

        CoordinateEntity coordinateEntity16 = coordinateService.saveCoordinate(48.85532458336893, 2.364427008194676);
        placeService.savePlace("Hotel de Béthune-Sully", "Monument", coordinateEntity16, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(19, 0, 0), 0.00);

        CoordinateEntity coordinateEntity17 = coordinateService.saveCoordinate(48.88685974869238, 2.3430399344103514);
        placeService.savePlace("Basilique du Sacré-Coeur de Montmartre", "Lieu de culte", coordinateEntity17, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(6, 0, 0), LocalTime.of(22, 30, 0), 0.00);

        CoordinateEntity coordinateEntity18 = coordinateService.saveCoordinate(48.87306599448159, 2.297788231917454);
        placeService.savePlace("Avenue des Champs-Élysées", "Quartier d'intérêt", coordinateEntity18, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(0, 0, 0), LocalTime.of(23, 59, 0), 0.00);

        CoordinateEntity coordinateEntity19 = coordinateService.saveCoordinate(48.85818844193142, 2.3489179349124143);
        placeService.savePlace("Tour Saint-Jacques", "Monument", coordinateEntity19, DayOfWeek.FRIDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0), 12.00);

        CoordinateEntity coordinateEntity20 = coordinateService.saveCoordinate(48.85525355220592, 2.3468695876488757);
        placeService.savePlace("Île de la Cité", "Quartier d'intérêt", coordinateEntity20, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(0, 0, 0), LocalTime.of(23, 59, 0), 0.00);

        CoordinateEntity coordinateEntity21 = coordinateService.saveCoordinate(48.86212267391677, 2.300997881117963);
        placeService.savePlace("Cathédrale de la Sainte-Trinité", "Lieu de culte", coordinateEntity21, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(14, 0, 0), LocalTime.of(19, 0, 0), 0.00);

        CoordinateEntity coordinateEntity22 = coordinateService.saveCoordinate(48.86569656101774, 2.321289347534348);
        placeService.savePlace("Place de la Concorde", "Quartier d'intérêt", coordinateEntity22, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(0, 0, 0), LocalTime.of(23, 59, 0), 0.00);

        CoordinateEntity coordinateEntity23 = coordinateService.saveCoordinate(48.86435037479113, 2.348041643521805);
        placeService.savePlace("Tour Jean-sans-Peur", "Monument", coordinateEntity23, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY, LocalTime.of(13, 30, 0), LocalTime.of(18, 0, 0), 6.00);

        CoordinateEntity coordinateEntity24 = coordinateService.saveCoordinate(48.84524303335598, 2.3528580641779517);
        placeService.savePlace("Arènes de Lutèce", "Monument", coordinateEntity24, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(19, 0, 0), 0.00);

        CoordinateEntity coordinateEntity25 = coordinateService.saveCoordinate(48.86461592834268, 2.2966407453267044);
        placeService.savePlace("Palais de Tokyo", "Musée", coordinateEntity25, DayOfWeek.WEDNESDAY, DayOfWeek.MONDAY, LocalTime.of(12, 0, 0), LocalTime.of(21, 0, 0), 12.00);

        CoordinateEntity coordinateEntity26 = coordinateService.saveCoordinate(48.871540502219624, 2.355119694411343);
        placeService.savePlace("Les Invalides", "Monument", coordinateEntity26, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0), 12.00);

        CoordinateEntity coordinateEntity27 = coordinateService.saveCoordinate(48.87627007132477, 2.336624179958064);
        placeService.savePlace("Jardin des Tuileries", "Jardin", coordinateEntity27, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(7, 0, 0), LocalTime.of(21, 0, 0), 0.00);

        CoordinateEntity coordinateEntity28 = coordinateService.saveCoordinate(48.86887393641594, 2.332576453042036);
        placeService.savePlace("Musée de l'Orangerie", "Musée", coordinateEntity28, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(18, 0, 0), 12.00);

        CoordinateEntity coordinateEntity29 = coordinateService.saveCoordinate(48.85383025337196, 2.3580430453054266);
        placeService.savePlace("Saint-Eustache", "Lieu de culte", coordinateEntity29, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(8, 0, 0), LocalTime.of(19, 0, 0), 0.00);

        CoordinateEntity coordinateEntity30 = coordinateService.saveCoordinate(48.85296688228024, 2.29442498267743);
        placeService.savePlace("Musée des Arts et Métiers", "Musée", coordinateEntity30, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0), 12.00);

        CoordinateEntity coordinateEntity31 = coordinateService.saveCoordinate(48.871540502219624, 2.355119694411343);
        placeService.savePlace("Passage Brady", "Quartier d'intérêt", coordinateEntity31, DayOfWeek.MONDAY, DayOfWeek.SATURDAY, LocalTime.of(9, 30, 0), LocalTime.of(23, 30, 0), 0.00);

        CoordinateEntity coordinateEntity32 = coordinateService.saveCoordinate(48.8723068631308, 2.3316018265859415);
        placeService.savePlace("Opéra national de Paris", "Monument", coordinateEntity32, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(10, 0, 0), LocalTime.of(17, 0, 0), 14.00);

        CoordinateEntity coordinateEntity33 = coordinateService.saveCoordinate(48.861521349900606, 2.393515417905678);
        placeService.savePlace("Cimetière du Père Lachaise", "Quartier d'intérêt", coordinateEntity33, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(8, 30, 0), LocalTime.of(17, 30, 0), 0.00);

        CoordinateEntity coordinateEntity34 = coordinateService.saveCoordinate(48.84220928620018, 2.321961579713815);
        placeService.savePlace("Observatoire Paris Montparnasse", "Monument", coordinateEntity34, DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9, 30, 0), LocalTime.of(22, 30, 0), 20.00);

        GraphService graphService = ctx.getBean(GraphService.class);
        graphService.saveGraph(placeService.getAllPlaces(), 5, 2);


    }

}
