package com.epam.jwd.model;

public class Line extends Figure{
    private Point firstPoint;
    private Point secondPoint;
    private String name;

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
    protected boolean validation() throws IllegalArgumentException{
        if (getFirstPoint().equals(getSecondPoint())){
            throw new IllegalArgumentException("Объект -> " + toString() + "не является фигурой " + getClass().getName());
        } else {
            return true;
        }
    }

    @Override
    public String resultOfValidation() throws IllegalArgumentException{
        if (validation()){
            return toString();
        } else {
            return "Exception happened";
        }
    }

    @Override
    public String toString(){
        return "Line: " + name + " from " + getFirstPoint().toString() + " to " + getSecondPoint().toString();
    }
}
