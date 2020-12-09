package com.epam.jwd.TaskFour.model.simpleFigure;

import java.util.Objects;

public class Point extends UnitFigure{
    private final int x;
    private final int y;
    private final String name;

    Point(int x, int y, String name){
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

    @Override
    public int hashCode(){
        return Objects.hash(x, y, name);
    }

    public static double destinationBetweenPoints(Point firstPoint, Point secondPoint){
        int x = Math.abs(secondPoint.getX() - firstPoint.getX());
        int y = Math.abs(secondPoint.getY() - firstPoint.getY());
        return Math.hypot(x,y);
    }
}