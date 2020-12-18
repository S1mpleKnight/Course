package com.epam.jwd.TaskFive.decorator;

import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.factory.FigureFactory;
import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.model.figures.Figure;
import com.epam.jwd.TaskFive.model.unitFigure.Point;
import com.epam.jwd.TaskFive.service.api.FigurePostProcessor;
import com.epam.jwd.TaskFive.service.impl.FigureExistencePostProcessor;

import java.util.List;

public class PostProcessingDecorator extends FigureFactoryDecorator{
    private final FigurePostProcessor[] POSTPROCESSORS = new FigurePostProcessor[]{FigureExistencePostProcessor.getPostProcessor()};
    private final FigureFactory FACTORY;

    PostProcessingDecorator(FigureFactory factory){
        this.FACTORY = factory;
    }

    @Override
    public Figure createFigure(GeometryUnitType type, String name, List<Point> figureConstituence) throws FigureException{
        Figure figure = FACTORY.createFigure(type, name, figureConstituence);
        for (FigurePostProcessor postProcessor: POSTPROCESSORS){
            figure = postProcessor.postProcess(figure);
        }
        return figure;
    }
}
