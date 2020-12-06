package com.epam.jwd.TaskThree.service.impl;

import com.epam.jwd.TaskThree.exception.FigureException;
import com.epam.jwd.TaskThree.exception.FigureNotExistException;
import com.epam.jwd.TaskThree.model.simpleFigure.Point;
import com.epam.jwd.TaskThree.model.figures.Figure;
import com.epam.jwd.TaskThree.model.figures.MultiAngleFigure;
import com.epam.jwd.TaskThree.model.figures.Square;
import com.epam.jwd.TaskThree.model.figures.Triangle;
import com.epam.jwd.TaskThree.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor{
    private static FigureExistencePostProcessor postProcessor;

    private FigureExistencePostProcessor(){
    }

    public static FigureExistencePostProcessor getPostProcessor(){
        if (postProcessor == null){
            postProcessor = new FigureExistencePostProcessor();
        }
        return postProcessor;
    }
    
    @Override
    public Figure postProcess(Figure figure) throws FigureException{
        if (figure instanceof MultiAngleFigure){
            return figure;
        }else if (figure instanceof Square){
            if (squareValidation((Square) figure)){
                return figure;
            } else {
                return null;
            }
        } else if (figure instanceof Triangle){
            if (triangleValidation((Triangle) figure)){
                return figure;
            } else {
                return null;
            }
        }else {
            throw new FigureException("No such figure implementation");
        }
    }

    private boolean triangleValidation(Triangle triangle) throws FigureNotExistException{
        double a = Point.destinationBetweenPoints(triangle.getFirstPoint(), triangle.getSecondPoint());
        double b = Point.destinationBetweenPoints(triangle.getSecondPoint(), triangle.getThirdPoint());
        double c = Point.destinationBetweenPoints(triangle.getThirdPoint(), triangle.getFirstPoint());
        if ((a + b) < c || (a + c) < b || (b + c) < a){
            throw new FigureNotExistException("Треугольник " + toString() + "не может существовать");
        } else if (threePointsOnOneLine(triangle)){
            throw new FigureNotExistException("Треугольник " + toString() + "не может существовать");
        } else {
            return true;
        }
    }

    private boolean threePointsOnOneLine(Triangle triangle){
        double X = (double) (triangle.getFirstPoint().getX() - triangle.getSecondPoint().getX())
                / (triangle.getThirdPoint().getX() - triangle.getSecondPoint().getX());
        double Y = (double) (triangle.getFirstPoint().getY() - triangle.getSecondPoint().getY())
                / (triangle.getThirdPoint().getY() - triangle.getSecondPoint().getY());
        if (X == Y){
            return true;
        } else {
            return false;
        }
    }
    private boolean squareValidation(Square square) throws FigureNotExistException{
        int firstWidth = Math.abs(square.getSecondPoint().getX() - square.getFirstPoint().getX());
        int secondWidth = Math.abs(square.getFourthPoint().getX() - square.getThirdPoint().getX());
        int firstHeight = Math.abs(square.getFourthPoint().getY() - square.getFirstPoint().getY());
        int secondHeight = Math.abs(square.getThirdPoint().getY() - square.getSecondPoint().getY());
        if (firstHeight == secondHeight && firstWidth == secondWidth && firstHeight == firstWidth){
            return true;
        } else {
            throw new FigureNotExistException("Объект " + toString() + "не является квадратом");
        }
    }
}
