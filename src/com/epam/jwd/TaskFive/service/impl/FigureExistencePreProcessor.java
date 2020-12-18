package com.epam.jwd.TaskFive.service.impl;

import com.epam.jwd.TaskFive.exception.FigureNotExistException;
import com.epam.jwd.TaskFive.model.unitFigure.Point;
import com.epam.jwd.TaskFive.service.api.FigurePreProcessor;

import java.util.List;

public class FigureExistencePreProcessor implements FigurePreProcessor{
   private static FigureExistencePreProcessor preProcessor;

   private FigureExistencePreProcessor(){
   }

   public static FigureExistencePreProcessor getPreProcessor(){
       if (preProcessor == null){
           preProcessor = new FigureExistencePreProcessor();
       }
       return preProcessor;
   }

    @Override
    public void preProcess(List<Point> list) throws FigureNotExistException{
        for (int i = 0; i < list.size(); i++){
            Point currentPoint = list.get(i);
            for (int j = i + 1; j < list.size(); j++){
                if (currentPoint.equals(list.get(j))){
                    throw new FigureNotExistException("There are 2 equals points");
                }
            }
        }
    }
}