package com.epam.jwd.TaskFour.model;

import com.epam.jwd.TaskFour.exception.DecoratorException;
import com.epam.jwd.TaskFour.factory.FigureFactory;

public interface ApplicationContext{
    FigureFactory createFigureFactory() throws DecoratorException;
}
