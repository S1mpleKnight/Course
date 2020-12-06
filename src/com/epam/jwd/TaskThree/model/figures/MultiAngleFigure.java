package com.epam.jwd.TaskThree.model.figures;

import com.epam.jwd.TaskThree.model.simpleFigure.Point;

public class MultiAngleFigure extends Figure{
    private final Point[] allPointsInFigure;
    private final int amountOfPointsInFigure;
    private final String name;

    MultiAngleFigure(Point[] allPointsInFigure, int amountOfPointsInFigure, String name){
        this.allPointsInFigure = allPointsInFigure;
        this.amountOfPointsInFigure = amountOfPointsInFigure;
        this.name = name;
    }

    public Point[] getAllPointsInFigure(){
        return allPointsInFigure;
    }

    public int getAmountOfPointsInFigure(){
        return amountOfPointsInFigure;
    }

    public String getName(){
        return name;
    }

    @Override
    protected double executeStrategyAreaCalculation(){
        return getFigurePropertiesStrategy().calculateTheArea();
    }

    @Override
    protected double executeStrategyPerimeterCalculation(){
        return getFigurePropertiesStrategy().calculateThePerimeter();
    }

    @Override
    public String showFigureInformation(){
        return "Perimeter: " + (executeStrategyPerimeterCalculation() == 0 ? "Coming soon;" : executeStrategyPerimeterCalculation())
                + " Area: " + (executeStrategyAreaCalculation() == 0 ? "Coming soon;" : executeStrategyAreaCalculation());
    }

    @Override
    public String toString(){
        if (amountOfPointsInFigure == 4){
            return "MultiAngleFigure: " + getName() + " " + allPointsInFigure[0].toString() + allPointsInFigure[1].toString()
                    + allPointsInFigure[2].toString() + allPointsInFigure[3].toString();
        } else if (amountOfPointsInFigure == 5){
            return "MultiAngleFigure: " + getName() + " " + allPointsInFigure[0].toString() + allPointsInFigure[1].toString()
                    + allPointsInFigure[2].toString() + allPointsInFigure[3].toString() + allPointsInFigure[4].toString();
        } else {
            return "MultiAngleFigure: " + getName() + " " + allPointsInFigure[0].toString() + allPointsInFigure[1].toString()
                    + allPointsInFigure[2].toString() + allPointsInFigure[3].toString() + allPointsInFigure[4].toString()
                    + allPointsInFigure[5].toString();
        }
    }

}
