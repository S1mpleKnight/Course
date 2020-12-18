package com.epam.jwd.TaskFive.service.api;

import com.epam.jwd.TaskFive.exception.FigureException;

import java.util.List;

public interface UnitFigurePreProcessor{
    void preProcess(List<Integer> list) throws FigureException;
}
