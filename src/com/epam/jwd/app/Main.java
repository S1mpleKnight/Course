package com.epam.jwd.app;

import com.epam.jwd.model.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Point[] arrayOfPoints = new Point[4];
    static Figure[] arrayOfLines = new Line[2];
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
        arrayOfPoints[0] = new Point(0,0, "A");
        arrayOfPoints[1] = new Point(1,1, "B");
        arrayOfPoints[2] = new Point(2,2, "C");
        arrayOfPoints[3] = new Point(2,2, "D");
        arrayOfLines[0] = new Line(arrayOfPoints[0], arrayOfPoints[1], "AB");
        arrayOfLines[1] = new Line(arrayOfPoints[2], arrayOfPoints[3], "CD");
        arrayOfTriangle[0] = new Triangle(arrayOfPoints[0], arrayOfPoints[1], arrayOfPoints[2], "ABC");
        arrayOfTriangle[1] = new Triangle(arrayOfPoints[1], arrayOfPoints[2], arrayOfPoints[3], "BCD");
        arrayOfSquare[0] = new Square(arrayOfPoints[0], arrayOfPoints[1], arrayOfPoints[2], arrayOfPoints[3], "ABCD");
    }

    private static void printPointsInfo(){
        int i = 0;
        do{
            LOGGER.log(Level.INFO, arrayOfPoints[i].toString());
            i++;
        }while (i < arrayOfPoints.length);
    }

    private static void printLinesInfo(){
        for (Figure arrayOfLine : arrayOfLines){
            try{
                LOGGER.log(Level.INFO, arrayOfLine.resultOfValidation());
            } catch (IllegalArgumentException exception){
                LOGGER.log(Level.ERROR, exception.getMessage());
            }
        }
    }

    private static void printTriangleInfo(){
        for (Figure triangle : arrayOfTriangle){
            try{
                LOGGER.log(Level.INFO, triangle.resultOfValidation());
            } catch (IllegalArgumentException exception){
                LOGGER.log(Level.ERROR, exception.getMessage());
            }
        }
    }

    private static void printSquareInfo(){
        for (Figure square : arrayOfSquare){
            try{
                LOGGER.log(Level.INFO, square.resultOfValidation());
            } catch (IllegalArgumentException exception){
                LOGGER.log(Level.ERROR, exception.getMessage());
            }
        }
    }
}
