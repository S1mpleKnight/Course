package com.epam.jwd.TaskFour.service.api;

import com.epam.jwd.TaskFour.exception.FigureException;
import com.epam.jwd.TaskFour.model.figures.Figure;

public interface FigurePostProcessor{
    Figure postProcess(Figure figure) throws FigureException;
}
