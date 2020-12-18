package com.epam.jwd.TaskFive.factory;

import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.model.figures.Figure;
import com.epam.jwd.TaskFive.model.unitFigure.Point;

import java.util.List;

public interface FigureFactory{
    Figure createFigure(GeometryUnitType type, String name, List<Point> figureConstituence) throws FigureException;
}
