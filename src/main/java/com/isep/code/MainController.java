package com.isep.code;

import com.isep.code.Entity.DefaultEntity;
import com.isep.code.Entity.GraphEntity;
import com.isep.code.Entity.NodeEntity;
import com.isep.code.Entity.PlaceEntity;
import com.isep.code.Service.DefaultService;
import com.isep.code.Service.GraphService;
import com.isep.code.Service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
public class MainController {
    private final PlaceService placeService;
    private final GraphService graphService;
    private final DefaultService defaultService;

    @Autowired
    public MainController(PlaceService placeService, GraphService graphService, DefaultService defaultService) {
        this.placeService = placeService;
        this.graphService = graphService;
        this.defaultService = defaultService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        List<GraphEntity> graphs = graphService.findAllGraphs();
        model.addAttribute("graphs", graphs);
        return "admin";
    }

    @PostMapping("/add-places")
    public String addPlaces() {
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
        return "redirect:/admin";
    }

    @PostMapping("/add-graph")
    public String addGraph(@RequestParam(value = "numberOfNeighbors", required = false) String numberOfNeighbors,
                           @RequestParam(value = "travelMode", required = false) String travelMode) {
        if (Objects.equals(numberOfNeighbors, "") || Objects.equals(travelMode, "")) {
            return "redirect:/admin";
        }
        GraphEntity graph = graphService.saveGraph();
        List<PlaceEntity> places = placeService.findAllPlaces();
        int tempNumberOfNeighbors = Integer.parseInt(numberOfNeighbors);
        int tempTravelMode = Integer.parseInt(travelMode);
        graphService.initGraph(graph, places, tempNumberOfNeighbors, tempTravelMode);
        return "redirect:/admin";
    }

    @PostMapping("/add-default-graph")
    public String addDefaultGraph(@RequestParam(value = "travelMode", required = false) String travelMode,
                                  @RequestParam(value = "graph", required = false) String graph) {
        if (Objects.equals(travelMode, "") || Objects.equals(graph, "")) {
            return "redirect:/admin";
        }
        Long idGraph = Long.parseLong(graph);
        int tempTravelMode = Integer.parseInt(travelMode);
        GraphEntity tempGraph = graphService.findGraphById(idGraph);
        defaultService.saveDefault(tempGraph, tempTravelMode);
        return "redirect:/admin";
    }

    @PostMapping("/delete-graph")
    public String deleteGraph(@RequestParam(value = "graph", required = false) String graph) {
        if (Objects.equals(graph, "")) {
            return "redirect:/admin";
        }
        Long idGraph = Long.parseLong(graph);
        GraphEntity tempGraph = graphService.findGraphById(idGraph);
        defaultService.deleteAllDefaultsByGraph(tempGraph);
        graphService.deleteGraphByGraphOrId(tempGraph, idGraph);
        return "redirect:/admin";
    }

    @PostMapping("/search")
    @ResponseBody
    public List<NodeEntity> search(
            @RequestParam("travelMode") String travelMode,
            @RequestParam("placeType") String placeType,
            @RequestParam(value = "budget", required = false) String budget,
            @RequestParam(value = "duration", required = false) String duration) {
        if (Objects.equals(travelMode, "") || Objects.equals(budget, "") || Objects.equals(duration, "")) {
            return Collections.emptyList();
        }
        DefaultEntity default_ = defaultService.findDefaultByTravelMode(Integer.parseInt(travelMode));
        GraphEntity graph = default_.getGraph();
        double tempBudget = Double.parseDouble(budget);
        double tempDuration = Double.parseDouble(duration) / 2;
        return graphService.findBestSolution(graph, placeType, tempBudget, tempDuration);
    }

}