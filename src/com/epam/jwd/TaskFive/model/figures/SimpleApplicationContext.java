package com.epam.jwd.TaskFive.model.figures;

import com.epam.jwd.TaskFive.decorator.DecoratorFactory;
import com.epam.jwd.TaskFive.decorator.DecoratorType;
import com.epam.jwd.TaskFive.exception.DecoratorException;
import com.epam.jwd.TaskFive.factory.FigureFactory;
import com.epam.jwd.TaskFive.model.ApplicationContext;

public class SimpleApplicationContext implements ApplicationContext{
    @Override
    public FigureFactory createFigureFactory() throws DecoratorException{
        return DecoratorFactory.createDecorator(DecoratorType.POSTDECORATOR,
                DecoratorFactory.createDecorator(DecoratorType.PREDECORATOR, new SimpleFigureFactory()));
    }
}
