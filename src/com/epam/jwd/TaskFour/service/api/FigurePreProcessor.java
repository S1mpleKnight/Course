package com.epam.jwd.TaskFour.service.api;

import com.epam.jwd.TaskFour.exception.FigureNotExistException;
import com.epam.jwd.TaskFour.model.simpleFigure.Point;

public interface FigurePreProcessor{
   void preProcess(Point[] array) throws FigureNotExistException;
}
