package com.epam.jwd.TaskThree.model.figures;

import com.epam.jwd.TaskThree.exception.FigureException;
import com.epam.jwd.TaskThree.exception.FigureNotExistException;
import com.epam.jwd.TaskThree.model.GeometryUnitType;
import com.epam.jwd.TaskThree.model.simpleFigure.Point;
import com.epam.jwd.TaskThree.service.FigurePostProcessor;
import com.epam.jwd.TaskThree.service.FigurePreProcessor;
import com.epam.jwd.TaskThree.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.TaskThree.service.impl.FigureExistencePreProcessor;
import com.epam.jwd.TaskThree.strategy.ConcreteStrategyMultiAngleFigure;
import com.epam.jwd.TaskThree.strategy.ConcreteStrategySquare;
import com.epam.jwd.TaskThree.strategy.ConcreteStrategyTriangle;

public class FiguresFactory{
    private static final FigurePreProcessor PREPROCESSOR = FigureExistencePreProcessor.getPreProcessor();
    private static final FigurePostProcessor POSTPROCESSOR = FigureExistencePostProcessor.getPostProcessor();

    public static Figure createFigure(GeometryUnitType type, String name, int amountOfAngles, Point... array) throws FigureException{
        Figure figure;
        PREPROCESSOR.preProcess(array);
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
                figure = new MultiAngleFigure(array, amountOfAngles, name);
                figure.setStrategy(ConcreteStrategyMultiAngleFigure.getStrategy());
                break;
            case LINE:
            case POINT:
                throw new FigureException("Use another factory");
            default:
                throw new FigureException("This type isn't exist");
        }
        return POSTPROCESSOR.postProcess(figure);
    }
}
