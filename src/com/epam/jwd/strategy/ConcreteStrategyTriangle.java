package com.epam.jwd.strategy;

import com.epam.jwd.entity.Point;

public enum ConcreteStrategyTriangle implements Strategy{
    SINGLESTRATEGY;

    @Override
    public double calculateTheArea(Point... var){
        double a = Point.destinationBetweenPoints(var[0], var[1]);
        double b = Point.destinationBetweenPoints(var[1], var[2]);
        double c = Point.destinationBetweenPoints(var[2], var[0]);
        return calculateHeronsFormula(a, b, c);
    }

    @Override
    public double calculateThePerimeter(Point ... var){
        double a = Point.destinationBetweenPoints(var[0], var[1]);
        double b = Point.destinationBetweenPoints(var[1], var[2]);
        double c = Point.destinationBetweenPoints(var[2], var[0]);
        return (long) (a + b + c);
    }

    private double calculateHeronsFormula(double a, double b, double c){
        double  p = (a + b + c) / 2;
        return  Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
