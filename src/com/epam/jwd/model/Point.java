package com.epam.jwd.model;

public class Point {
    private int x;
    private int y;
    private String name;

    public Point(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Point: " + name + "(" + x + "," + y + ") ";
    }

    @Override
    public boolean equals(Object anotherPoint){
        if (this == anotherPoint){
            return true;
        }
        if (anotherPoint == null || getClass() != anotherPoint.getClass()){
            return false;
        }
        Point point = (Point) anotherPoint;
        return x == point.x && y == point.y;
    }

    public static double destinationBetweenPoints(Point firstPoint, Point secondPoint){
        int x = Math.abs(secondPoint.getX() - firstPoint.getX());
        int y = Math.abs(secondPoint.getY() - firstPoint.getY());
        return Math.hypot(x,y);
    }
}