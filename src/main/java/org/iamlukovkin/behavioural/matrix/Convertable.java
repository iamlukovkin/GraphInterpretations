package org.iamlukovkin.behavioural.matrix;

import org.iamlukovkin.structural.Graph;

public interface Convertable {
    Graph getGraph();
    void setGraph();
    void setGraph(Graph graph);
    void setMatrix(int[][] matrix);
    void setMatrix();
    String toString();
}
