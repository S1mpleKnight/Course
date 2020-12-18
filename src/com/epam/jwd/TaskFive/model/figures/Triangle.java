package com.epam.jwd.TaskFive.model.figures;

import com.epam.jwd.TaskFive.model.unitFigure.Point;

public class Triangle extends Figure{
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private String name;

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

    public void setFirstPoint(Point firstPoint){
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(Point secondPoint){
        this.secondPoint = secondPoint;
    }

    public void setThirdPoint(Point thirdPoint){
        this.thirdPoint = thirdPoint;
    }

    public void setName(String name){
        this.name = name;
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

    public boolean containPoint(Point point){
        return this.getFirstPoint().equals(point) || getSecondPoint().equals(point) || getThirdPoint().equals(point);
    }
}
