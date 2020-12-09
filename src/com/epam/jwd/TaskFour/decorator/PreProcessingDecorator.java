package com.epam.jwd.TaskFour.decorator;

import com.epam.jwd.TaskFour.exception.FigureException;
import com.epam.jwd.TaskFour.factory.FigureFactory;
import com.epam.jwd.TaskFour.model.GeometryUnitType;
import com.epam.jwd.TaskFour.model.figures.Figure;
import com.epam.jwd.TaskFour.model.simpleFigure.Point;
import com.epam.jwd.TaskFour.service.api.FigurePreProcessor;
import com.epam.jwd.TaskFour.service.impl.FigureExistencePreProcessor;

public class PreProcessingDecorator extends FigureFactoryDecorator{
    private final FigurePreProcessor[] PREPROCESSORS = new FigurePreProcessor[]{FigureExistencePreProcessor.getPreProcessor()};
    private final FigureFactory FACTORY;

    PreProcessingDecorator(FigureFactory factory){
        this.FACTORY = factory;
    }

    @Override
    public Figure createFigure(GeometryUnitType type, String name, Point[] figureConstituence) throws FigureException{
        for (FigurePreProcessor preProcessor: PREPROCESSORS){
            preProcessor.preProcess(figureConstituence);
        }
        return FACTORY.createFigure(type, name, figureConstituence);
    }
}
