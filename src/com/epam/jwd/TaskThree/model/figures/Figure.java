package com.epam.jwd.TaskThree.model.figures;

import com.epam.jwd.TaskThree.strategy.Strategy;

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
