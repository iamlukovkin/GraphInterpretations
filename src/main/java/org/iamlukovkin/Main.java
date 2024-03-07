package org.iamlukovkin;

import org.iamlukovkin.behavioural.matrix.Adjacency;
import org.iamlukovkin.behavioural.matrix.Incidence;

public class Main {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = SourceItems.getAdjacencyMatrix();
        Adjacency sourceAdjacency = new Adjacency(adjacencyMatrix);
        Incidence returnedIncidence = new Incidence(sourceAdjacency.getGraph());
        System.out.println(returnedIncidence);

        int [][] incidenceMatrix = SourceItems.getIncidenceMatrix();
        Incidence sourceIncidence = new Incidence(incidenceMatrix);
        Adjacency returnedAdjacency = new Adjacency(sourceIncidence.getGraph());
        System.out.println(returnedAdjacency);
    }
}