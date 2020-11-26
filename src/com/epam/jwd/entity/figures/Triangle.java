package com.epam.jwd.entity.figures;

import com.epam.jwd.entity.Point;

public class Triangle extends Figure{
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;
    private final String name;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint, String name){
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.name = name;
    }

    public Point getFirstPoint(){
        return firstPoint;
    }

    public Point getSecondPoint(){
        return secondPoint;
    }

    public Point getThirdPoint(){
        return thirdPoint;
    }

    public String getName(){
        return name;
    }

    @Override
    protected double executeStrategyAreaCalculation(){
        return getFigurePropertiesStrategy().calculateTheArea(getFirstPoint(), getSecondPoint(), getThirdPoint());
    }

    @Override
    protected double executeStrategyPerimeterCalculation(){
        return getFigurePropertiesStrategy().calculateThePerimeter(getFirstPoint(), getSecondPoint(), getThirdPoint());
    }

    @Override
    protected boolean validation() throws IllegalArgumentException{
        if (getFirstPoint().equals(getSecondPoint()) || getFirstPoint().equals(getThirdPoint())
                || getSecondPoint().equals(getThirdPoint())){
            throw new IllegalArgumentException("Объект -> " + toString() + "не является фигурой " + getClass().getName());
        } else {
            return true;
        }
    }

    @Override
    public String resultOfValidation() throws IllegalArgumentException{
        if (!validation()){
            return "Exception happened";
        } else if (!triangleValidation()){             
            return "Exception happened";
        } else {
            return toString();
        }
    }

    @Override
    public String toString(){
        return "Triangle " + getName() + ": " + getFirstPoint().toString() + getSecondPoint().toString()
                + getThirdPoint().toString();
    }

    private boolean triangleValidation() throws IllegalArgumentException{
        double a = Point.destinationBetweenPoints(getFirstPoint(), getSecondPoint());
        double b = Point.destinationBetweenPoints(getSecondPoint(), getThirdPoint());
        double c = Point.destinationBetweenPoints(getThirdPoint(), getFirstPoint());
        if ((a + b) < c || (a + c) < b || (b + c) < a){
            throw new IllegalArgumentException("Треугольник " + toString() + "не может существовать");
        } else if (threePointsOnOneLine()){
            throw new IllegalArgumentException("Треугольник " + toString() + "не может существовать");
        } else {
            return true;
        }
    }

    private boolean threePointsOnOneLine(){
        double X = (double) (getFirstPoint().getX() - getSecondPoint().getX()) / (getThirdPoint().getX() - getSecondPoint().getX());
        double Y = (double) (getFirstPoint().getY() - getSecondPoint().getY()) / (getThirdPoint().getY() - getSecondPoint().getY());
        if (X == Y){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String showFigureInformation(){
        return "Perimeter: " + executeStrategyPerimeterCalculation() + " Area: " + executeStrategyAreaCalculation();
    }
}
