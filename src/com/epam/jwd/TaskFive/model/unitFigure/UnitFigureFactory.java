package com.epam.jwd.TaskFive.model.unitFigure;

import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.service.api.UnitFigurePreProcessor;
import com.epam.jwd.TaskFive.service.impl.UnitFigureExistencePreProcessor;

import java.util.List;

public class UnitFigureFactory{
    private static final UnitFigurePreProcessor PREPROCESSOR = UnitFigureExistencePreProcessor.getPreProcessor();

    public static UnitFigure createFigure(GeometryUnitType type, String name, List<Integer> numbers) throws FigureException{
        PREPROCESSOR.preProcess(numbers);
        UnitFigure figure;
        switch (type){
            case POINT:
                figure = new Point(numbers.get(0), numbers.get(1), name);
                break;
            case LINE:
                figure = new Line(name, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3));
                break;
            case MULTI_ANGLE:
            case TRIANGLE:
            case SQUARE:
                throw new FigureException("Wrong type of Figure");
            default:
                throw new FigureException("This type isn't exist");
        }
        return figure;
    }

}
