package com.epam.jwd.TaskThree.service;

import com.epam.jwd.TaskThree.exception.FigureNotExistException;
import com.epam.jwd.TaskThree.model.simpleFigure.Point;

public interface FigurePreProcessor{
   void preProcess(Point[] array) throws FigureNotExistException;
}
