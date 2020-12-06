package com.epam.jwd.TaskThree.service;

import com.epam.jwd.TaskThree.exception.FigureException;
import com.epam.jwd.TaskThree.model.figures.Figure;

public interface FigurePostProcessor{
    Figure postProcess(Figure figure) throws FigureException;
}
