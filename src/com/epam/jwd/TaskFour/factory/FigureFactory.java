package com.epam.jwd.TaskFour.factory;

import com.epam.jwd.TaskFour.exception.FigureException;
import com.epam.jwd.TaskFour.model.GeometryUnitType;
import com.epam.jwd.TaskFour.model.figures.Figure;
import com.epam.jwd.TaskFour.model.simpleFigure.Point;

public interface FigureFactory{
    Figure createFigure(GeometryUnitType type, String name, Point[] figureConstituence) throws FigureException;
}
