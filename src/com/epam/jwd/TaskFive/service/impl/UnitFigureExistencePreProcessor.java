package com.epam.jwd.TaskFive.service.impl;

import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.exception.FigureNotExistException;
import com.epam.jwd.TaskFive.service.api.UnitFigurePreProcessor;

import java.util.List;

public class UnitFigureExistencePreProcessor implements UnitFigurePreProcessor{
    private static UnitFigureExistencePreProcessor preProcessor;

    private UnitFigureExistencePreProcessor(){
    }

    public static UnitFigureExistencePreProcessor getPreProcessor(){
        if (preProcessor == null){
            preProcessor = new UnitFigureExistencePreProcessor();
        }
        return preProcessor;
    }

    @Override
    public void preProcess(List<Integer> list) throws FigureException{
        if (list.size() > 2){
            if (list.get(0).equals(list.get(2)) && list.get(1).equals(list.get(3))){
                throw new FigureNotExistException("There are 2 equals points");
            }
        }
    }
}
