package com.epam.jwd.TaskFour.decorator;

import com.epam.jwd.TaskFour.exception.FigureException;
import com.epam.jwd.TaskFour.factory.FigureFactory;
import com.epam.jwd.TaskFour.model.GeometryUnitType;
import com.epam.jwd.TaskFour.model.figures.Figure;
import com.epam.jwd.TaskFour.model.simpleFigure.Point;
import com.epam.jwd.TaskFour.service.api.FigurePostProcessor;
import com.epam.jwd.TaskFour.service.impl.FigureExistencePostProcessor;

public class PostProcessingDecorator extends FigureFactoryDecorator{
    private final FigurePostProcessor[] POSTPROCESSORS = new FigurePostProcessor[]{FigureExistencePostProcessor.getPostProcessor()};
    private final FigureFactory FACTORY;

    PostProcessingDecorator(FigureFactory factory){
        this.FACTORY = factory;
    }

    @Override
    public Figure createFigure(GeometryUnitType type, String name, Point[] figureConstituence) throws FigureException{
        Figure figure = FACTORY.createFigure(type, name, figureConstituence);
        for (FigurePostProcessor postProcessor: POSTPROCESSORS){
            figure = postProcessor.postProcess(figure);
        }
        return figure;
    }
}
