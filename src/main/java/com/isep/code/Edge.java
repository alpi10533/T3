package com.isep.code;

public class Edge {

    private final Node source;
    private final Node destination;
    private final double weight;

    public Edge(Node source, Node destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Node from() {
        return source;
    }
    public Node to() {
        return destination;
    }
    public double weight() {
        return weight;
    }

}