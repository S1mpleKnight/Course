package com.epam.jwd.TaskFour.app;

import com.epam.jwd.TaskFour.exception.DecoratorException;
import com.epam.jwd.TaskFour.exception.FigureException;
import com.epam.jwd.TaskFour.factory.FigureFactory;
import com.epam.jwd.TaskFour.model.ApplicationContext;
import com.epam.jwd.TaskFour.model.figures.SimpleApplicationContext;
import com.epam.jwd.TaskFour.model.simpleFigure.Line;
import com.epam.jwd.TaskFour.model.simpleFigure.Point;
import com.epam.jwd.TaskFour.model.figures.Figure;
import com.epam.jwd.TaskFour.model.GeometryUnitType;
import com.epam.jwd.TaskFour.model.figures.MultiAngleFigure;
import com.epam.jwd.TaskFour.model.figures.Square;
import com.epam.jwd.TaskFour.model.figures.Triangle;
import com.epam.jwd.TaskFour.model.simpleFigure.UnitFigure;
import com.epam.jwd.TaskFour.model.simpleFigure.UnitFigureFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final int[] X_Y_INITIALIZER = {0, 0, 2, 0, 2, 2, 0, 2, 1, 2, 2, 1};
    private static final char[] NAME_INITIALIZER = {'A', 'B', 'C', 'D', 'E', 'F'};
    private static final UnitFigure[] ARRAY_OF_POINTS = new Point[6];
    private static final UnitFigure[] ARRAY_OF_LINES = new Line[2];
    private static final Figure[] ARRAY_OF_TRIANGLES = new Triangle[2];
    private static final Figure[] ARRAY_OF_SQUARES = new Square[1];
    private static final Figure[] ARRAY_OF_MULTI_ANGLES = new MultiAngleFigure[3];
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        final ApplicationContext APPLICATION_CONTEXT = new SimpleApplicationContext();
        try{
            final FigureFactory FACTORY = APPLICATION_CONTEXT.createFigureFactory();
            Point[] array = new Point[6];
            createEntities(array, FACTORY);
        } catch (DecoratorException e){
            LOGGER.log(Level.ERROR, e.getMessage());
        }
    }

    private static void createEntities(Point[] array, FigureFactory factory){
        createPoints();
        createLines();
        createTriangles(factory);
        createSquare(factory);
        createMultiAngles(castToPoint(array), factory);
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
                ARRAY_OF_POINTS[i] = UnitFigureFactory.createFigure(GeometryUnitType.POINT,
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
                ARRAY_OF_LINES[i] = UnitFigureFactory.createFigure(GeometryUnitType.LINE,
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

    private static void createTriangles(FigureFactory factory){
        int i = 0;
        do{
            try{
                Point[] arrayForThisTriangle = {(Point) ARRAY_OF_POINTS[i],
                        (Point) ARRAY_OF_POINTS[i+1],
                        (Point) ARRAY_OF_POINTS[i+2]};
                ARRAY_OF_TRIANGLES[i] = factory.createFigure(GeometryUnitType.TRIANGLE,
                        "" + NAME_INITIALIZER[i] + NAME_INITIALIZER[i+1] + NAME_INITIALIZER[i+2], arrayForThisTriangle);
                LOGGER.log(Level.INFO, ARRAY_OF_TRIANGLES[i].toString());
                LOGGER.log(Level.INFO, ARRAY_OF_TRIANGLES[i].showFigureInformation());
            } catch (FigureException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            }
            i++;
        }while (i < ARRAY_OF_TRIANGLES.length);
    }

    private static void createSquare(FigureFactory factory){
        try{
            Point[] arrayForThisSquare = {(Point) ARRAY_OF_POINTS[0],
                    (Point) ARRAY_OF_POINTS[1],
                    (Point) ARRAY_OF_POINTS[2],
                    (Point) ARRAY_OF_POINTS[3]};
            ARRAY_OF_SQUARES[0] = factory.createFigure(GeometryUnitType.SQUARE, "ABCD", arrayForThisSquare);
            LOGGER.log(Level.INFO, ARRAY_OF_SQUARES[0].toString());
            LOGGER.log(Level.INFO, ARRAY_OF_SQUARES[0].showFigureInformation());
        } catch (FigureException e){
            LOGGER.log(Level.ERROR, e.getMessage());
        }
    }

    private static void createMultiAngles(Point[] array, FigureFactory factory){
        int i = 0, amount = 4;
        do{
            try{
                ARRAY_OF_MULTI_ANGLES[i] = factory.createFigure(GeometryUnitType.MULTI_ANGLE,
                        createMultiAngleName(amount), array);
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
