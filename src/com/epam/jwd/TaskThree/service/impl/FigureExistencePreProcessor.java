package com.epam.jwd.TaskThree.service.impl;

import com.epam.jwd.TaskThree.exception.FigureNotExistException;
import com.epam.jwd.TaskThree.model.simpleFigure.Point;
import com.epam.jwd.TaskThree.service.FigurePreProcessor;

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
    public void preProcess(Point[] array) throws FigureNotExistException{
        for (int i = 0; i < array.length; i++){
            Point currentPoint = array[i];
            for (int j = i + 1; j < array.length; j++){
                if (currentPoint.equals(array[j])){
                    throw new FigureNotExistException("There are 2 equals points");
                }
            }
        }
    }
}