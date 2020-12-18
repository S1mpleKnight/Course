package com.epam.jwd.TaskFive.service.api;

import com.epam.jwd.TaskFive.exception.FigureNotExistException;
import com.epam.jwd.TaskFive.model.unitFigure.Point;

import java.util.List;

public interface FigurePreProcessor{
   void preProcess(List<Point> array) throws FigureNotExistException;
}
