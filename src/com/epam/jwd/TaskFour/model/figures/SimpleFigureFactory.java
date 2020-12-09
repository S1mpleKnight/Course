package com.epam.jwd.TaskFour.model.figures;

import com.epam.jwd.TaskFour.exception.FigureException;
import com.epam.jwd.TaskFour.factory.FigureFactory;
import com.epam.jwd.TaskFour.model.GeometryUnitType;
import com.epam.jwd.TaskFour.model.simpleFigure.Point;
import com.epam.jwd.TaskFour.service.api.FigurePostProcessor;
import com.epam.jwd.TaskFour.service.api.FigurePreProcessor;
import com.epam.jwd.TaskFour.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.TaskFour.service.impl.FigureExistencePreProcessor;
import com.epam.jwd.TaskFour.strategy.ConcreteStrategyMultiAngleFigure;
import com.epam.jwd.TaskFour.strategy.ConcreteStrategySquare;
import com.epam.jwd.TaskFour.strategy.ConcreteStrategyTriangle;

public class SimpleFigureFactory implements FigureFactory{
    private static final FigurePreProcessor PREPROCESSOR = FigureExistencePreProcessor.getPreProcessor();
    private static final FigurePostProcessor POSTPROCESSOR = FigureExistencePostProcessor.getPostProcessor();

    @Override
    public Figure createFigure(GeometryUnitType type, String name, Point... array) throws FigureException{
        Figure figure;
        switch (type){
            case SQUARE:
                figure = new Square(array[0], array[1], array[2], array[3], name);
                figure.setStrategy(ConcreteStrategySquare.getSingleStrategy());
                break;
            case TRIANGLE:
                figure = new Triangle(array[0], array[1], array[2], name);
                figure.setStrategy(ConcreteStrategyTriangle.SINGLESTRATEGY);
                break;
            case MULTI_ANGLE:
                figure = new MultiAngleFigure(array, name);
                figure.setStrategy(ConcreteStrategyMultiAngleFigure.getStrategy());
                break;
            case LINE:
            case POINT:
                throw new FigureException("Use another factory");
            default:
                throw new FigureException("This type isn't exist");
        }
        return figure;
    }
}
