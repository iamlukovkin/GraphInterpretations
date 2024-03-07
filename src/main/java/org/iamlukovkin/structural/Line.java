package org.iamlukovkin.structural;

public class Line {
    private int source;
    private int target;

    public Line(int source, int target) {
        setSource(source);
        setTarget(target);
    }

    public void setSource(int source) {
        if (source < 0) {
            throw new IllegalArgumentException();
        }
        this.source = source;
    }

    public void setTarget(int target) {
        if (target < 0) {
            throw new IllegalArgumentException();
        }
        this.target = target;
    }

    public int getSource() {
        return source;
    }

    public int getTarget() {
        return target;
    }

    public int[] getPoints() {
        int[] points = new int[2];
        points[0] = source;
        points[1] = target;
        return points;
    }

    @Override
    public String toString() {
        return "Line {source=" + (getSource() + 1) + "; target=" + (getTarget() + 1) + "}";
    }
}
