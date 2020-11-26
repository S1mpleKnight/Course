package com.epam.jwd.entity;

public class Line {
    private final Point firstPoint;
    private final Point secondPoint;
    private final String name;

    public Line(Point firstPoint, Point secondPoint, String name){
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
