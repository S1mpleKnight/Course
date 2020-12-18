package com.epam.jwd.TaskFive.strategy;

import com.epam.jwd.TaskFive.model.unitFigure.Point;

public class ConcreteStrategySquare implements Strategy{
    private static ConcreteStrategySquare singleStrategy;

    private ConcreteStrategySquare(){
    }

    public static ConcreteStrategySquare getSingleStrategy(){
        if (singleStrategy == null){
            singleStrategy = new ConcreteStrategySquare();
        }
        return singleStrategy;
    }

    @Override
    public double calculateTheArea(Point... var){
        double a = Point.destinationBetweenPoints(var[0], var[1]);
        return a * a;
    }

    @Override
    public double calculateThePerimeter(Point ... var){
        double a = Point.destinationBetweenPoints(var[0], var[1]);
        return a * 4;
    }
}
