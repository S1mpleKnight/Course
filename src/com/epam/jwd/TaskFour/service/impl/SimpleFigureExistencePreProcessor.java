package com.epam.jwd.TaskFour.service.impl;

import com.epam.jwd.TaskFour.exception.FigureException;
import com.epam.jwd.TaskFour.exception.FigureNotExistException;
import com.epam.jwd.TaskFour.service.api.SimpleFigurePreProcessor;

public class SimpleFigureExistencePreProcessor implements SimpleFigurePreProcessor{
    private static SimpleFigureExistencePreProcessor preProcessor;

    private SimpleFigureExistencePreProcessor(){
    }

    public static SimpleFigureExistencePreProcessor getPreProcessor(){
        if (preProcessor == null){
            preProcessor = new SimpleFigureExistencePreProcessor();
        }
        return preProcessor;
    }

    @Override
    public void preProcess(int[] array) throws FigureException{
        if (array.length > 2){
            if (array[0] == array[2] && array[1] == array[3]){
                throw new FigureNotExistException("There are 2 equals points");
            }
        }
    }
}
