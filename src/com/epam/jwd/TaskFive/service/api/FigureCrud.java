package com.epam.jwd.TaskFive.service.api;

import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.model.figures.Figure;
import com.epam.jwd.TaskFive.model.unitFigure.Point;
import com.epam.jwd.TaskFive.service.storage.SearchCriterion;

import java.util.ArrayList;
import java.util.List;

public interface FigureCrud{
    Figure createFigure(GeometryUnitType type, String name, List<Point> list) throws FigureException;
    List<Figure> multiCreateFigure(GeometryUnitType type, String[] names, List<Point> list) throws FigureException;
    Figure findFigure(GeometryUnitType type, String name) throws FigureException;
    List<Figure> findByCriterion(SearchCriterion criterion) throws FigureException;
    Figure updateFigure(GeometryUnitType type, String name, ArrayList<Point> list, String newName) throws FigureException;
    void deleteFigure(GeometryUnitType type, String name) throws FigureException;
}
