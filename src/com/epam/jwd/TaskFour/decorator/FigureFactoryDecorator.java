package com.epam.jwd.TaskFour.decorator;

import com.epam.jwd.TaskFour.exception.FigureException;
import com.epam.jwd.TaskFour.factory.FigureFactory;
import com.epam.jwd.TaskFour.model.GeometryUnitType;
import com.epam.jwd.TaskFour.model.figures.Figure;
import com.epam.jwd.TaskFour.model.simpleFigure.Point;

public abstract class FigureFactoryDecorator implements FigureFactory{
    @Override
    public Figure createFigure(GeometryUnitType type, String name, Point[] figureConstituence) throws FigureException{
        return null;
    }
}
