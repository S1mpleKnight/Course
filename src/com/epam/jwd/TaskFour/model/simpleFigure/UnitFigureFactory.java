package com.epam.jwd.TaskFour.model.simpleFigure;

import com.epam.jwd.TaskFour.exception.FigureException;
import com.epam.jwd.TaskFour.model.GeometryUnitType;
import com.epam.jwd.TaskFour.service.api.SimpleFigurePreProcessor;
import com.epam.jwd.TaskFour.service.impl.SimpleFigureExistencePreProcessor;

public class UnitFigureFactory{
    private static final SimpleFigurePreProcessor PREPROCESSOR = SimpleFigureExistencePreProcessor.getPreProcessor();

    public static UnitFigure createFigure(GeometryUnitType type, String name, int ...numbers) throws FigureException{
        PREPROCESSOR.preProcess(numbers);
        UnitFigure figure;
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
