package com.epam.jwd.TaskFive.model.figures;

import com.epam.jwd.TaskFive.model.unitFigure.Point;

public class Square extends Figure{
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;
    private String name;

    Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, String name){
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
        this.name = name;
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

    public void setFourthPoint(Point fourthPoint){
        this.fourthPoint = fourthPoint;
    }

    public void setName(String name){
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

    public Point getFourthPoint(){
        return fourthPoint;
    }

    @Override
    protected double executeStrategyAreaCalculation(){
        return getFigurePropertiesStrategy().calculateTheArea(getFirstPoint(), getSecondPoint());
    }

    @Override
    protected double executeStrategyPerimeterCalculation(){
        return getFigurePropertiesStrategy().calculateThePerimeter(getFirstPoint(), getSecondPoint());
    }

    @Override
    public String toString(){
        return "Square " + getName() + ": " + getFirstPoint() + getSecondPoint() + getThirdPoint() + getFourthPoint();
    }

    @Override
    public String showFigureInformation(){
       return "Perimeter: " + executeStrategyPerimeterCalculation() + " Area: " + executeStrategyAreaCalculation();
    }

    public boolean containPoint(Point point){
        return this.getFirstPoint().equals(point) || getSecondPoint().equals(point) || getThirdPoint().equals(point)
                || this.getFourthPoint().equals(point);
    }
}
