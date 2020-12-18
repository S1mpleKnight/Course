package com.epam.jwd.TaskFive.model;

import com.epam.jwd.TaskFive.exception.DecoratorException;
import com.epam.jwd.TaskFive.factory.FigureFactory;

public interface ApplicationContext{
    FigureFactory createFigureFactory() throws DecoratorException;
}
