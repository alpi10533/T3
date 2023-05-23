package com.isep.code;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final List<Edge> edges;
    private int numberOfNodes;
    private int numberOfEdges;

    public Graph() {
        this.numberOfNodes = 0;
        this.numberOfEdges = 0;
        this.edges = new ArrayList<>();
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public List<Edge> getEdges() {return edges;}

    public List<String> getStringNodes() {
        ArrayList<String> nodes = new ArrayList<>();
        for (Edge edge : edges) {
            if (!nodes.contains(edge.from().getName())) {
                nodes.add(edge.from().getName());
            }
            if (!nodes.contains(edge.to().getName())) {
                nodes.add(edge.to().getName());
            }
        }
        return nodes;
    }

    public void addEdge(String sourceName, String destinationName, double weight) {
        Node source = searchNodeByName(sourceName);
        if (source == null) {
            source = new Node(sourceName);
            numberOfNodes++;
        }
        Node destination = searchNodeByName(destinationName);
        if (destination == null) {
            destination = new Node(destinationName);
            numberOfNodes++;
        }
        edges.add(new Edge(source, destination, weight));
        numberOfEdges++;
    }

    public Node searchNodeByName(String name) {
        for (Edge edge : edges) {
            if (edge.from().getName().equals(name)) {
                return edge.from();
            } else if (edge.to().getName().equals(name)) {
                return edge.to();
            }
        }
        return null;
    }

}
