package org.iamlukovkin.structural;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Line> lines;

    public Graph() {
        setLines(new ArrayList<>());
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public int getLinesCount() {
        int result = 0;
        for (Line line : getLines()) {
            result++;
        }
        return result;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Line line : getLines()) {
            result.append(lines.indexOf(line) + 1).append(": ").append(line.toString());
            result.append("\n");
        }
        return result.toString();
    }

    public int getPointsCount() {
        ArrayList<Integer> points = new ArrayList<>();
        for (Line line : getLines()) {
            if (!points.contains(line.getSource())) {
                points.add(line.getSource());
            }
            if (!points.contains(line.getTarget())) {
                points.add(line.getTarget());
            }
        }
        return points.size();
    }
}
