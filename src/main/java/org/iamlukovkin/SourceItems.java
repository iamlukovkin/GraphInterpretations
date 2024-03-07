package org.iamlukovkin;

public class SourceItems {
    private static final int[][] adjacencyMatrix = {
            {0, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 1}
    };

    private static final int [][] incidenceMatrix = {
            {1, 1, 0, 0, 0, -1, 0, -1, 0, 0},
            {-1, 0, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, -1, 0, 0, -1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, -1, 0, 0, 0},
            {0, 0, 0, -1, 0, 1, 1, 0, -1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 2}
    };

    public static int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public static int[][] getIncidenceMatrix() {
        return incidenceMatrix;
    }
}
