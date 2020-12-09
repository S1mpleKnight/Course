package com.epam.jwd.TaskFour.service.api;

import com.epam.jwd.TaskFour.exception.FigureException;

public interface SimpleFigurePreProcessor{
    void preProcess(int[] array) throws FigureException;
}
