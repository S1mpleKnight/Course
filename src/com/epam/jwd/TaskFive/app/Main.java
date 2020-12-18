package com.epam.jwd.TaskFive.app;

import com.epam.jwd.TaskFive.exception.DecoratorException;
import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.factory.FigureFactory;
import com.epam.jwd.TaskFive.model.ApplicationContext;
import com.epam.jwd.TaskFive.model.figures.SimpleApplicationContext;
import com.epam.jwd.TaskFive.model.unitFigure.Point;
import com.epam.jwd.TaskFive.model.figures.Figure;
import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.model.unitFigure.UnitFigure;
import com.epam.jwd.TaskFive.model.unitFigure.UnitFigureFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final int[] X_Y_INITIALIZER = {0, 0, 2, 0, 2, 2, 0, 2, 1, 2, 2, 1};
    private static final char[] NAME_INITIALIZER = {'A', 'B', 'C', 'D', 'E', 'F'};
    private static final List<UnitFigure> ARRAY_OF_POINTS = new ArrayList<>(6);
    private static final List<UnitFigure> ARRAY_OF_LINES = new ArrayList<>(2);
    private static final List<Figure> ARRAY_OF_TRIANGLES = new ArrayList<>(2);
    private static final List<Figure> ARRAY_OF_SQUARES = new ArrayList<>(1);
    private static final List<Figure> ARRAY_OF_MULTI_ANGLES = new ArrayList<>(3);
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        final ApplicationContext APPLICATION_CONTEXT = new SimpleApplicationContext();
        try{
            final FigureFactory FACTORY = APPLICATION_CONTEXT.createFigureFactory();
            ArrayList<Point> list = new ArrayList<>(6);
            createEntities(list, FACTORY);
        } catch (DecoratorException e){
            LOGGER.log(Level.ERROR, e.getMessage());
        }
    }

    private static void createEntities(ArrayList<Point> array, FigureFactory factory){
        createPoints();
        createLines();
        createTriangles(factory);
        createSquare(factory);
        createMultiAngles(castToPoint(array), factory);
    }

    private static ArrayList<Point> castToPoint(ArrayList<Point> list){
        for (int i = 0; i < ARRAY_OF_POINTS.size(); i++){
            list.add(i, (Point) ARRAY_OF_POINTS.get(i));
        }
        return list;
    }

    private static void createPoints(){
        int i = 0, coordinates = 0, current = 0;
        do{
            try{
                List<Integer> list = Arrays.asList(X_Y_INITIALIZER[coordinates++], X_Y_INITIALIZER[coordinates++]);
                ARRAY_OF_POINTS.add(i, UnitFigureFactory.createFigure(GeometryUnitType.POINT,
                        Character.toString(NAME_INITIALIZER[current++]), list));
                LOGGER.log(Level.INFO, ARRAY_OF_POINTS.get(i).toString());
            } catch (FigureException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            }
            i++;
        }while (i < 6);
    }

    private static void createLines(){
        int i = 0, coordinates = 0, current = 0;
        do{
            try{
                List<Integer> list = Arrays.asList(X_Y_INITIALIZER[coordinates++], X_Y_INITIALIZER[coordinates++],
                        X_Y_INITIALIZER[coordinates++], X_Y_INITIALIZER[coordinates++]);
                ARRAY_OF_LINES.add(i, UnitFigureFactory.createFigure(GeometryUnitType.LINE,
                        "" + NAME_INITIALIZER[current++] + NAME_INITIALIZER[current++], list));
                LOGGER.log(Level.INFO, ARRAY_OF_LINES.get(i).toString());
            } catch (FigureException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            }
            i++;
        }while (i < 2);
    }

    private static void createTriangles(FigureFactory factory){
        int i = 0;
        do{
            try{
                Point[] arrayForThisTriangle = {(Point) ARRAY_OF_POINTS.get(i),
                        (Point) ARRAY_OF_POINTS.get(i+1),
                        (Point) ARRAY_OF_POINTS.get(i+2)};
                List<Point> list = Arrays.asList(arrayForThisTriangle);
                ARRAY_OF_TRIANGLES.add(i, factory.createFigure(GeometryUnitType.TRIANGLE,
                        "" + NAME_INITIALIZER[i] + NAME_INITIALIZER[i+1] + NAME_INITIALIZER[i+2], list));
                LOGGER.log(Level.INFO, ARRAY_OF_TRIANGLES.get(i).toString());
                LOGGER.log(Level.INFO, ARRAY_OF_TRIANGLES.get(i).showFigureInformation());
            } catch (FigureException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            }
            i++;
        }while (i < 2);
    }

    private static void createSquare(FigureFactory factory){
        try{
            Point[] arrayForThisSquare = {(Point) ARRAY_OF_POINTS.get(0),
                    (Point) ARRAY_OF_POINTS.get(1),
                    (Point) ARRAY_OF_POINTS.get(2),
                    (Point) ARRAY_OF_POINTS.get(3)};
            List<Point> list = Arrays.asList(arrayForThisSquare);
            ARRAY_OF_SQUARES.add(0, factory.createFigure(GeometryUnitType.SQUARE, "ABCD", list));
            LOGGER.log(Level.INFO, ARRAY_OF_SQUARES.get(0).toString());
            LOGGER.log(Level.INFO, ARRAY_OF_SQUARES.get(0).showFigureInformation());
        } catch (FigureException e){
            LOGGER.log(Level.ERROR, e.getMessage());
        }
    }

    private static void createMultiAngles(ArrayList<Point> list, FigureFactory factory){
        int i = 0, amount = 4;
        do{
            try{
                ARRAY_OF_MULTI_ANGLES.add(i,factory.createFigure(GeometryUnitType.MULTI_ANGLE,
                        createMultiAngleName(amount), list));
                LOGGER.log(Level.INFO, ARRAY_OF_MULTI_ANGLES.get(i).toString());
                LOGGER.log(Level.INFO, ARRAY_OF_MULTI_ANGLES.get(i).showFigureInformation()) ;
            } catch (FigureException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            }
            i++;
            amount++;
        }while (i < 3);
    }

    private static String createMultiAngleName(int amountOfAngles){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < amountOfAngles; i++){
            sb.append(NAME_INITIALIZER[i]);
        }
        return sb.toString();
    }
}
