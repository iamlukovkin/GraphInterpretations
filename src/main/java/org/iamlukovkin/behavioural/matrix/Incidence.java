package org.iamlukovkin.behavioural.matrix;

import org.iamlukovkin.structural.Graph;
import org.iamlukovkin.structural.Line;

import java.util.ArrayList;


public class Incidence implements Convertable {
    private int[][] matrix;
    private Graph graph;

    public Incidence(Graph graph) {
        setGraph(graph);
        setMatrix();
    }

    public Incidence(int[][] matrix) {
        setMatrix(matrix);
        setGraph();
    }

    public Graph getGraph() {
        if (graph.getLinesCount() == 0) {
            setGraph();
        }
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void setMatrix() {
        if (graph.getLinesCount() == 0) {
            throw new IllegalArgumentException("Graph must have at least one line");
        }
        this.matrix = new int[graph.getPointsCount()][graph.getLinesCount()];
        for (int i = 0; i < graph.getLinesCount(); i++) {
            Line line = graph.getLines().get(i);
            if (line.getSource() == line.getTarget()) {
                matrix[line.getSource()][i] = 2;
            } else {
                matrix[line.getSource()][i] = 1;
                matrix[line.getTarget()][i] = -1;
            }
        }
    }

    public void setGraph() {
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Matrix must not be empty");
        }
        this.graph = new Graph();

        for (int i = 0; i < matrix[0].length; i++) {
            ArrayList<Integer> relation = new ArrayList<>();
            for (int[] row : matrix) {
                relation.add(row[i]);
            }
            if (relation.contains(2)) {
                int pointIndex = relation.indexOf(2);
                graph.addLine(new Line(pointIndex, pointIndex));
            } else {
                int pointIndex = relation.indexOf(1);
                int targetIndex = relation.indexOf(-1);
                graph.addLine(new Line(pointIndex, targetIndex));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Incidence matrix:\n");
        for (int i = 0; i < matrix.length; i++) {
            int[] line = matrix[i];
            result.append("x").append(i + 1).append(": ");
            for (int point : line) {
                result.append("| ").append(point);
                if (Integer.toString(point).length() == 1) {
                    result.append(" ");
                }
            }
            result.append("|\n");
        }
        return result.toString();
    }
}
