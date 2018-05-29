package com.mrxia.snake.module;

/**
 * 坐标点类
 *
 * @author xiazijian
 */
public class Point {

    private int x;

    private int y;

    private int hash;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        int h = hash;
        if (h == 0) {
            int[] val = {x, y};

            for (int v : val) {
                h = 31 * h + v;
            }
            hash = h;
        }
        return h;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof Point) {
            Point otherPoint = (Point) obj;
            return otherPoint.getX() == this.x && otherPoint.getY() == this.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}
