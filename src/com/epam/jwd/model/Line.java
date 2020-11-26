package com.epam.jwd.model;

import java.util.Objects;

public class Line {
    private final Point firstPoint;
    private final Point secondPoint;
    private final String name;

    Line(Point firstPoint, Point secondPoint, String name){
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.name = name;
    }

    public Point getFirstPoint(){
        return firstPoint;
    }

    public Point getSecondPoint(){
        return secondPoint;
    }

    @Override
    public String toString(){
        return "Line: " + name + " from " + getFirstPoint().toString() + " to " + getSecondPoint().toString();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return firstPoint.equals(line.firstPoint) && secondPoint.equals(line.secondPoint)
                || firstPoint.equals(line.secondPoint) && secondPoint.equals(line.firstPoint);
    }

    @Override
    public int hashCode(){
        return Objects.hash(firstPoint, secondPoint);
    }

    protected boolean validation() throws IllegalArgumentException{
        if (getFirstPoint().equals(getSecondPoint())){
            throw new IllegalArgumentException("Объект -> " + toString() + "не является фигурой " + getClass().getName());
        } else {
            return true;
        }
    }


    public String resultOfValidation() throws IllegalArgumentException{
        if (validation()){
            return toString();
        } else {
            return "Exception happened";
        }
    }
}
