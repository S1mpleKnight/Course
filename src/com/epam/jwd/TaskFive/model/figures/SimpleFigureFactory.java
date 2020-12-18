package com.epam.jwd.TaskFive.model.figures;

import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.factory.FigureFactory;
import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.model.unitFigure.Point;
import com.epam.jwd.TaskFive.strategy.ConcreteStrategyMultiAngleFigure;
import com.epam.jwd.TaskFive.strategy.ConcreteStrategySquare;
import com.epam.jwd.TaskFive.strategy.ConcreteStrategyTriangle;

import java.util.List;

public class SimpleFigureFactory implements FigureFactory{
    @Override
    public Figure createFigure(GeometryUnitType type, String name, List<Point> list) throws FigureException{
        Figure figure;
        switch (type){
            case SQUARE:
                figure = new Square(list.get(0), list.get(1), list.get(2), list.get(3), name);
                figure.setStrategy(ConcreteStrategySquare.getSingleStrategy());
                break;
            case TRIANGLE:
                figure = new Triangle(list.get(0), list.get(1), list.get(2), name);
                figure.setStrategy(ConcreteStrategyTriangle.SINGLESTRATEGY);
                break;
            case MULTI_ANGLE:
                figure = new MultiAngleFigure(list, name);
                figure.setStrategy(ConcreteStrategyMultiAngleFigure.getStrategy());
                break;
            case LINE:
            case POINT:
                throw new FigureException("Wrong type of Figure");
            default:
                throw new FigureException("This type isn't exist");
        }
        return figure;
    }
}
