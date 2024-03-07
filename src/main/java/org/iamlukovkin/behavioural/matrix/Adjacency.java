package org.iamlukovkin.behavioural.matrix;

import org.iamlukovkin.structural.*;

public class Adjacency implements Convertable {
    private int[][] matrix;
    private Graph graph;

    public Adjacency(int[][] matrix) {
        this.graph = new Graph();
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Matrix must be square");
        }
        setMatrix(matrix);
    }

    public Adjacency(Graph graph) {
        this.graph = graph;
        setMatrix();
    }

    public Graph getGraph() {
        if (graph.getLinesCount() == 0) {
            setGraph();
        }
        return graph;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void setMatrix() {
        createZeroMatrix();
        for (int i = 0; i < graph.getLinesCount(); i++) {
            Line line = graph.getLines().get(i);
            matrix[line.getSource()][line.getTarget()] = 1;
        }
    }

    private void createZeroMatrix() {
        this.matrix = new int[graph.getPointsCount()][graph.getPointsCount()];
        for (int i = 0; i < graph.getPointsCount(); i++) {
            for (int j = 0; j < graph.getPointsCount(); j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void setGraph() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    this.graph.addLine(new Line(i, j));
                }
            }
        }
    }

    @Override
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Adjacency matrix: \n");
        for(int i = 0; i < matrix.length; i++) {
            result.append("x").append(i + 1).append(": | ");
            int[] row = matrix[i];
            for(int point : row) {
                result.append(point).append(" | ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
