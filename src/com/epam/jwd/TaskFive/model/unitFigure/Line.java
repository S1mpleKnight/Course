package com.epam.jwd.TaskFive.model.unitFigure;

import java.util.Objects;

public class Line extends UnitFigure{
    private final Point firstPoint;
    private final Point secondPoint;
    private final String name;

    Line(String name, int firstX, int firstY, int secondX, int secondY){
        this.firstPoint = new Point(firstX, firstY, name.substring(0, 1));
        this.secondPoint = new Point(secondX, secondY, name.substring(1));
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
