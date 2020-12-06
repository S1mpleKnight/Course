package com.epam.jwd.TaskThree.model.figures;

import com.epam.jwd.TaskThree.model.simpleFigure.Point;

public class Square extends Triangle{
    private final Point fourthPoint;

    Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, String name){
        super(firstPoint, secondPoint, thirdPoint, name);
        this.fourthPoint = fourthPoint;
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
}
