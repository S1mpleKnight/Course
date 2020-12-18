package com.epam.jwd.TaskFive.model.figures;

import com.epam.jwd.TaskFive.model.unitFigure.Point;

import java.util.ArrayList;
import java.util.List;

public class MultiAngleFigure extends Figure{
    private ArrayList<Point> allPointsInFigure;
    private String name;

    MultiAngleFigure(List<Point> allPointsInFigure, String name){
        this.allPointsInFigure = (ArrayList<Point>) allPointsInFigure;
        this.name = name;
    }

    public void setAllPointsInFigure(ArrayList<Point> allPointsInFigure){
        this.allPointsInFigure = allPointsInFigure;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Point> getAllPointsInFigure(){
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
        if (allPointsInFigure.size() == 4){
            return "MultiAngleFigure: " + getName() + " " + allPointsInFigure.get(0).toString() + allPointsInFigure.get(1).toString()
                    + allPointsInFigure.get(2).toString() + allPointsInFigure.get(3).toString();
        } else if (allPointsInFigure.size() == 5){
            return "MultiAngleFigure: " + getName() + " " + allPointsInFigure.get(0).toString() + allPointsInFigure.get(1).toString()
                    + allPointsInFigure.get(2).toString() + allPointsInFigure.get(3).toString() + allPointsInFigure.get(4).toString();
        } else {
            return "MultiAngleFigure: " + getName() + " " + allPointsInFigure.get(0).toString() + allPointsInFigure.get(1).toString()
                    + allPointsInFigure.get(2).toString() + allPointsInFigure.get(3).toString() + allPointsInFigure.get(4).toString()
                    + allPointsInFigure.get(5).toString();
        }
    }


    public boolean containPoint(Point point){
        return this.getAllPointsInFigure().contains(point);
    }
}
