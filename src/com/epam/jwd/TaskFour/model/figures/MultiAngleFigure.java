package com.epam.jwd.TaskFour.model.figures;

import com.epam.jwd.TaskFour.model.simpleFigure.Point;

public class MultiAngleFigure extends Figure{
    private final Point[] allPointsInFigure;
    private final String name;

    MultiAngleFigure(Point[] allPointsInFigure, String name){
        this.allPointsInFigure = allPointsInFigure;
        this.name = name;
    }

    public Point[] getAllPointsInFigure(){
        return allPointsInFigure;
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
        if (allPointsInFigure.length == 4){
            return "MultiAngleFigure: " + getName() + " " + allPointsInFigure[0].toString() + allPointsInFigure[1].toString()
                    + allPointsInFigure[2].toString() + allPointsInFigure[3].toString();
        } else if (allPointsInFigure.length == 5){
            return "MultiAngleFigure: " + getName() + " " + allPointsInFigure[0].toString() + allPointsInFigure[1].toString()
                    + allPointsInFigure[2].toString() + allPointsInFigure[3].toString() + allPointsInFigure[4].toString();
        } else {
            return "MultiAngleFigure: " + getName() + " " + allPointsInFigure[0].toString() + allPointsInFigure[1].toString()
                    + allPointsInFigure[2].toString() + allPointsInFigure[3].toString() + allPointsInFigure[4].toString()
                    + allPointsInFigure[5].toString();
        }
    }

}
