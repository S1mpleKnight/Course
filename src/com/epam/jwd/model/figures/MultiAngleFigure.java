package com.epam.jwd.model.figures;

import com.epam.jwd.model.Point;

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
    protected boolean validation() throws IllegalArgumentException{
        if (amountOfPointsInFigure == 4){
            return fourSidesFigureValidation(this.allPointsInFigure);
        } else if (amountOfPointsInFigure == 5){
            return fiveSidesFigureValidation(this.allPointsInFigure);
        } else if (amountOfPointsInFigure == 6){
            return sixSidesFigureValidation(this.allPointsInFigure);
        } else {
            throw new IllegalArgumentException("Can't create this figure");
        }
    }

    @Override
    public String resultOfValidation() throws IllegalArgumentException{
        if (!validation()){
            return "Exception happened";
        }  else {
            return toString();
        }
    }

    @Override
    public String showFigureInformation(){
        return "Perimeter: " + (executeStrategyPerimeterCalculation() == 0 ? "Coming soon" : executeStrategyPerimeterCalculation())
                + " Area: " + (executeStrategyAreaCalculation() == 0 ? "Coming soon" : executeStrategyAreaCalculation());
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

    private boolean fourSidesFigureValidation(Point[] points) throws IllegalArgumentException{
        if (points[0].equals(points[1]) || points[0].equals(points[2]) || points[0].equals(points[3])
                || points[1].equals(points[2]) || points[1].equals(points[3]) || points[2].equals(points[3])){
            throw new IllegalArgumentException("Объект -> " + toString() + "не является фигурой " + getClass().getName());
        } else {
            return true;
        }
    }


    private boolean fiveSidesFigureValidation(Point[] points) throws IllegalArgumentException{
        if (points[0].equals(points[1]) || points[0].equals(points[2]) || points[0].equals(points[3])
                || points[0].equals(points[4]) || points[1].equals(points[2]) || points[1].equals(points[3])
                || points[1].equals(points[4]) || points[2].equals(points[3]) || points[2].equals(points[4])
                || points[3].equals(points[4])){
            throw new IllegalArgumentException("Объект -> " + toString() + "не является фигурой " + getClass().getName());
        } else {
            return true;
        }
    }

    private boolean sixSidesFigureValidation(Point[] points) throws IllegalArgumentException{
        if (points[0].equals(points[1]) || points[0].equals(points[2]) || points[0].equals(points[3])
                || points[0].equals(points[4]) || points[0].equals(points[5]) || points[1].equals(points[2])
                || points[1].equals(points[3]) || points[1].equals(points[4]) || points[1].equals(points[5])
                || points[2].equals(points[3]) || points[2].equals(points[4]) || points[2].equals(points[5])
                || points[3].equals(points[4]) || points[3].equals(points[5]) || points[4].equals(points[5])){
            throw new IllegalArgumentException("Объект -> " + toString() + "не является фигурой " + getClass().getName());
        } else {
            return true;
        }
    }
}
