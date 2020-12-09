package com.epam.jwd.TaskFour.model.figures;

import com.epam.jwd.TaskFour.strategy.Strategy;

public abstract class Figure{
    private Strategy figurePropertiesStrategy;

    public void setStrategy(Strategy strategy){
        this.figurePropertiesStrategy = strategy;
    }

    protected Strategy getFigurePropertiesStrategy(){
        return figurePropertiesStrategy;
    }

    protected abstract double executeStrategyAreaCalculation();

    protected abstract double executeStrategyPerimeterCalculation();

    public abstract String showFigureInformation();
}
