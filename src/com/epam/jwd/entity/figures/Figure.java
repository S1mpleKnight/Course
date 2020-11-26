package com.epam.jwd.entity.figures;

import com.epam.jwd.strategy.Strategy;

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

    protected abstract boolean validation();

    public abstract String resultOfValidation();

    public abstract String showFigureInformation();
}
