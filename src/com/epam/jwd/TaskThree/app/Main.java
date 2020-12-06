package com.epam.jwd.TaskThree.app;

import com.epam.jwd.TaskThree.exception.FigureException;
import com.epam.jwd.TaskThree.model.simpleFigure.Line;
import com.epam.jwd.TaskThree.model.simpleFigure.Point;
import com.epam.jwd.TaskThree.model.figures.Figure;
import com.epam.jwd.TaskThree.model.GeometryUnitType;
import com.epam.jwd.TaskThree.model.figures.FiguresFactory;
import com.epam.jwd.TaskThree.model.figures.MultiAngleFigure;
import com.epam.jwd.TaskThree.model.figures.Square;
import com.epam.jwd.TaskThree.model.figures.Triangle;
import com.epam.jwd.TaskThree.model.simpleFigure.SimpleFigure;
import com.epam.jwd.TaskThree.model.simpleFigure.SimpleFigureFactory;
import com.epam.jwd.TaskThree.strategy.ConcreteStrategyMultiAngleFigure;
import com.epam.jwd.TaskThree.strategy.ConcreteStrategySquare;
import com.epam.jwd.TaskThree.strategy.ConcreteStrategyTriangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final int[] X_Y_INITIALIZER = {0, 0, 2, 0, 2, 2, 0, 2, 1, 2, 2, 1};
    private static final char[] NAME_INITIALIZER = {'A', 'B', 'C', 'D', 'E', 'F'};
    private static final SimpleFigure[] ARRAY_OF_POINTS = new Point[6];
    private static final SimpleFigure[] ARRAY_OF_LINES = new Line[2];
    private static final Figure[] ARRAY_OF_TRIANGLES = new Triangle[2];
    private static final Figure[] ARRAY_OF_SQUARES = new Square[1];
    private static final Figure[] ARRAY_OF_MULTI_ANGLES = new MultiAngleFigure[3];
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        createPoints();
        createLines();
        createTriangles();
        createSquare();
        Point[] array = new Point[6];
        createMultiAngles(castToPoint(array));
    }

    private static Point[] castToPoint(Point[] array){
        for (int i = 0; i < ARRAY_OF_POINTS.length; i++){
            array[i] = (Point) ARRAY_OF_POINTS[i];
        }
        return array;
    }

    private static void createPoints(){
        int i = 0, coordinates = 0, current = 0;
        do{
            try{
                ARRAY_OF_POINTS[i] = SimpleFigureFactory.createFigure(GeometryUnitType.POINT,
                        Character.toString(NAME_INITIALIZER[current++]),
                        X_Y_INITIALIZER[coordinates++], X_Y_INITIALIZER[coordinates++]);
                LOGGER.log(Level.INFO, ARRAY_OF_POINTS[i].toString());
            } catch (FigureException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            }
            i++;
        }while (i < ARRAY_OF_POINTS.length);
    }

    private static void createLines(){
        int i = 0, coordinates = 0, current = 0;
        do{
            try{
                ARRAY_OF_LINES[i] = SimpleFigureFactory.createFigure(GeometryUnitType.LINE,
                        "" + NAME_INITIALIZER[current++] + NAME_INITIALIZER[current++],
                        X_Y_INITIALIZER[coordinates++], X_Y_INITIALIZER[coordinates++],
                        X_Y_INITIALIZER[coordinates++], X_Y_INITIALIZER[coordinates++]);
                LOGGER.log(Level.INFO, ARRAY_OF_LINES[i].toString());
            } catch (FigureException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            }
            i++;
        }while (i < ARRAY_OF_LINES.length);
    }

    private static void createTriangles(){
        int i = 0;
        do{
            try{
                ARRAY_OF_TRIANGLES[i] = FiguresFactory.createFigure(GeometryUnitType.TRIANGLE,
                        "" + NAME_INITIALIZER[i] + NAME_INITIALIZER[i+1] + NAME_INITIALIZER[i+2], 3,
                        (Point) ARRAY_OF_POINTS[i], (Point) ARRAY_OF_POINTS[i+1], (Point) ARRAY_OF_POINTS[i+2]);
                LOGGER.log(Level.INFO, ARRAY_OF_TRIANGLES[i].toString());
                LOGGER.log(Level.INFO, ARRAY_OF_TRIANGLES[i].showFigureInformation());
            } catch (FigureException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            }
            i++;
        }while (i < ARRAY_OF_TRIANGLES.length);
    }

    private static void createSquare(){
        try{
            ARRAY_OF_SQUARES[0] = FiguresFactory.createFigure(GeometryUnitType.SQUARE, "ABCD", 4,
                    (Point) ARRAY_OF_POINTS[0], (Point) ARRAY_OF_POINTS[1], (Point) ARRAY_OF_POINTS[2],
                    (Point) ARRAY_OF_POINTS[3]);
            LOGGER.log(Level.INFO, ARRAY_OF_SQUARES[0].toString());
            LOGGER.log(Level.INFO, ARRAY_OF_SQUARES[0].showFigureInformation());
        } catch (FigureException e){
            LOGGER.log(Level.ERROR, e.getMessage());
        }
    }

    private static void createMultiAngles(Point[] array){
        int i = 0, amount = 4;
        do{
            try{
                ARRAY_OF_MULTI_ANGLES[i] = FiguresFactory.createFigure(GeometryUnitType.MULTI_ANGLE,
                        createMultiAngleName(amount), amount, array);
                LOGGER.log(Level.INFO, ARRAY_OF_MULTI_ANGLES[i].toString());
                LOGGER.log(Level.INFO, ARRAY_OF_MULTI_ANGLES[i].showFigureInformation());
            } catch (FigureException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            }
            i++;
            amount++;
        }while (i < ARRAY_OF_MULTI_ANGLES.length);
    }

    private static String createMultiAngleName(int amountOfAngles){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < amountOfAngles; i++){
            sb.append(NAME_INITIALIZER[i]);
        }
        return sb.toString();
    }
}
