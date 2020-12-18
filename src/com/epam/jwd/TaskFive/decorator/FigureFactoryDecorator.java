package com.epam.jwd.TaskFive.decorator;

import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.factory.FigureFactory;
import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.model.figures.Figure;
import com.epam.jwd.TaskFive.model.unitFigure.Point;

import java.util.List;

public abstract class FigureFactoryDecorator implements FigureFactory{
    @Override
    public Figure createFigure(GeometryUnitType type, String name, List<Point> figureConstituence) throws FigureException{
        return null;
    }
}
