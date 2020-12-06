package com.epam.jwd.TaskThree.strategy;

import com.epam.jwd.TaskThree.model.simpleFigure.Point;

public class ConcreteStrategyMultiAngleFigure implements Strategy{
    private ConcreteStrategyMultiAngleFigure(){
    }

    private static class ConcreteMultiAngleFigureHolder{
        private final static ConcreteStrategyMultiAngleFigure singleStrategy = new ConcreteStrategyMultiAngleFigure();
    }

    public static ConcreteStrategyMultiAngleFigure getStrategy(){
        return ConcreteMultiAngleFigureHolder.singleStrategy;
    }

    @Override
    public double calculateTheArea(Point... var){
        return 0;
    }

    @Override
    public double calculateThePerimeter(Point... var){
        return 0;
    }
}
