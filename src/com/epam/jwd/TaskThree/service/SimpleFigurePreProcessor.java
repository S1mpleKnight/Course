package com.epam.jwd.TaskThree.service;

import com.epam.jwd.TaskThree.exception.FigureException;
import com.epam.jwd.TaskThree.model.simpleFigure.Point;

public interface SimpleFigurePreProcessor{
    void preProcess(int[] array) throws FigureException;
}
