package com.epam.jwd.TaskFour.decorator;

import com.epam.jwd.TaskFour.exception.DecoratorException;
import com.epam.jwd.TaskFour.factory.FigureFactory;

public class DecoratorFactory{
    public static FigureFactoryDecorator createDecorator(DecoratorType type, FigureFactory factory) throws DecoratorException{
        FigureFactoryDecorator decorator;
        switch (type){
            case PREDECORATOR:
                decorator = new PreProcessingDecorator(factory);
                break;
            case POSTDECORATOR:
                decorator = new PostProcessingDecorator(factory);
                break;
            default:
                throw new DecoratorException("Decoration mistake");
        }
        return decorator;
    }
}
