package com.epam.jwd.TaskFour.model.figures;

import com.epam.jwd.TaskFour.decorator.DecoratorFactory;
import com.epam.jwd.TaskFour.decorator.DecoratorType;
import com.epam.jwd.TaskFour.exception.DecoratorException;
import com.epam.jwd.TaskFour.factory.FigureFactory;
import com.epam.jwd.TaskFour.model.ApplicationContext;

public class SimpleApplicationContext implements ApplicationContext{
    @Override
    public FigureFactory createFigureFactory() throws DecoratorException{
        return DecoratorFactory.createDecorator(DecoratorType.POSTDECORATOR,
                DecoratorFactory.createDecorator(DecoratorType.PREDECORATOR, new SimpleFigureFactory()));
    }
}
