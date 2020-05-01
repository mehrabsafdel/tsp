package com.company;

public class Point {
    public int x;
    public int y;
    boolean visited = false;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point)
            return this.x == ((Point) obj).x && this.y == ((Point) obj).y ;

        return false;
    }

    public double distance(Point pt){

        return Math.sqrt(Math.pow(this.x - pt.x,2) + Math.pow(this.y - pt.y,2));
    }

}
