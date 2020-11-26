package com.epam.jwd.app;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.LineFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.figures.Figure;
import com.epam.jwd.model.figures.Square;
import com.epam.jwd.model.figures.SquareFactory;
import com.epam.jwd.model.figures.Triangle;
import com.epam.jwd.model.PointFactory;
import com.epam.jwd.model.figures.TriangleFactory;
import com.epam.jwd.strategy.ConcreteStrategySquare;
import com.epam.jwd.strategy.ConcreteStrategyTriangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Point[] arrayOfPoints = new Point[4];
    static Line[] arrayOfLines = new Line[2];
    static Figure[] arrayOfTriangle = new Triangle[2];
    static Figure[] arrayOfSquare = new Square[1];
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        initialization();
        printPointsInfo();
        printLinesInfo();
        printTriangleInfo();
        printSquareInfo();
    }

    public static void initialization(){
        arrayOfPoints[0] = PointFactory.createPoint(0,0, "A");
        arrayOfPoints[1] = PointFactory.createPoint(2,0, "B");
        arrayOfPoints[2] = PointFactory.createPoint(2,2, "C");
        arrayOfPoints[3] = PointFactory.createPoint(0,2, "D");
        arrayOfLines[0] = LineFactory.createLine(arrayOfPoints[0], arrayOfPoints[1], "AB");
        arrayOfLines[1] = LineFactory.createLine(arrayOfPoints[2], arrayOfPoints[3], "CD");
        arrayOfTriangle[0] = TriangleFactory.createTriangle(arrayOfPoints[0], arrayOfPoints[1], arrayOfPoints[2], "ABC");
        arrayOfTriangle[1] = TriangleFactory.createTriangle(arrayOfPoints[1], arrayOfPoints[2], arrayOfPoints[3], "BCD");
        arrayOfSquare[0] = SquareFactory.createSquare(arrayOfPoints[0], arrayOfPoints[1], arrayOfPoints[2], arrayOfPoints[3], "ABCD");
    }

    private static void printPointsInfo(){
        int i = 0;
        do{
            LOGGER.log(Level.INFO, arrayOfPoints[i].toString());
            i++;
        }while (i < arrayOfPoints.length);
    }

    private static void printLinesInfo(){
        for (Line arrayOfLine : arrayOfLines){
            try{
                LOGGER.log(Level.INFO, arrayOfLine.resultOfValidation());
            } catch (IllegalArgumentException exception){
                LOGGER.log(Level.ERROR, exception.getMessage());
            }
        }
    }

    private static void printTriangleInfo(){
        for (Figure figure : arrayOfTriangle){
            if (figure instanceof Triangle){
                figure.setStrategy(ConcreteStrategyTriangle.SINGLESTRATEGY);
            }
            try{
                LOGGER.log(Level.INFO, figure.resultOfValidation());
                LOGGER.log(Level.INFO, figure.showFigureInformation());
            } catch (IllegalArgumentException exception){
                LOGGER.log(Level.ERROR, exception.getMessage());
            }
        }
    }

    private static void printSquareInfo(){
        for (Figure figure : arrayOfSquare){
            if (figure instanceof Square){
                figure.setStrategy(ConcreteStrategySquare.getSingleStrategy());
            }
            try{
                LOGGER.log(Level.INFO, figure.resultOfValidation());
                LOGGER.log(Level.INFO, figure.showFigureInformation());
            } catch (IllegalArgumentException exception){
                LOGGER.log(Level.ERROR, exception.getMessage());
            }
        }
    }
}
