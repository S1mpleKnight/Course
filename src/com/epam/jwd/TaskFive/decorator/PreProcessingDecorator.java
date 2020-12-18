package com.epam.jwd.TaskFive.decorator;

import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.factory.FigureFactory;
import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.model.figures.Figure;
import com.epam.jwd.TaskFive.model.unitFigure.Point;
import com.epam.jwd.TaskFive.service.api.FigurePreProcessor;
import com.epam.jwd.TaskFive.service.impl.FigureExistencePreProcessor;

import java.util.List;

public class PreProcessingDecorator extends FigureFactoryDecorator{
    private final FigurePreProcessor[] PREPROCESSORS = new FigurePreProcessor[]{FigureExistencePreProcessor.getPreProcessor()};
    private final FigureFactory FACTORY;

    PreProcessingDecorator(FigureFactory factory){
        this.FACTORY = factory;
    }

    @Override
    public Figure createFigure(GeometryUnitType type, String name, List<Point> figureConstituence) throws FigureException{
        for (FigurePreProcessor preProcessor: PREPROCESSORS){
            preProcessor.preProcess(figureConstituence);
        }
        return FACTORY.createFigure(type, name, figureConstituence);
    }
}
