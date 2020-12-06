package com.epam.jwd.TaskThree.model.figures;

import com.epam.jwd.TaskThree.model.simpleFigure.Point;

public class Triangle extends Figure{
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;
    private final String name;

    Triangle(Point firstPoint, Point secondPoint, Point thirdPoint, String name){
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
    public String toString(){
        return "Triangle " + getName() + ": " + getFirstPoint().toString() + getSecondPoint().toString()
                + getThirdPoint().toString();
    }


    @Override
    public String showFigureInformation(){
        return "Perimeter: " + executeStrategyPerimeterCalculation() + " Area: " + executeStrategyAreaCalculation();
    }
}
