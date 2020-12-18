package com.epam.jwd.TaskFive.service.api;

import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.model.figures.Figure;

public interface FigurePostProcessor{
    Figure postProcess(Figure figure) throws FigureException;
}
