package com.epam.jwd.TaskThree.model.simpleFigure;

import com.epam.jwd.TaskThree.exception.FigureException;
import com.epam.jwd.TaskThree.model.GeometryUnitType;
import com.epam.jwd.TaskThree.service.SimpleFigurePreProcessor;
import com.epam.jwd.TaskThree.service.impl.SimpleFigureExistencePreProcessor;

public class SimpleFigureFactory{
    private static final SimpleFigurePreProcessor PREPROCESSOR = SimpleFigureExistencePreProcessor.getPreProcessor();

    public static SimpleFigure createFigure(GeometryUnitType type, String name, int ...numbers) throws FigureException{
        PREPROCESSOR.preProcess(numbers);
        SimpleFigure figure;
        switch (type){
            case POINT:
                figure = new Point(numbers[0], numbers[1], name);
                break;
            case LINE:
                figure = new Line(name, numbers[0], numbers[1], numbers[2], numbers[3]);
                break;
            case MULTI_ANGLE:
            case TRIANGLE:
            case SQUARE:
                throw new FigureException("Use another factory");
            default:
                throw new FigureException("This type isn't exist");
        }
        return figure;
    }

}
