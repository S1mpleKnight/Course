package com.epam.jwd.TaskFive.model.figures;

import com.epam.jwd.TaskFive.strategy.Strategy;

public abstract class Figure{
    private Strategy figurePropertiesStrategy;

    public void setStrategy(Strategy strategy){
        this.figurePropertiesStrategy = strategy;
    }

    protected Strategy getFigurePropertiesStrategy(){
        return figurePropertiesStrategy;
    }

    public abstract String getName();

    protected abstract double executeStrategyAreaCalculation();

    protected abstract double executeStrategyPerimeterCalculation();

    public abstract String showFigureInformation();
}
