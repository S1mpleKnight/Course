package com.epam.jwd.TaskFive.strategy;

import com.epam.jwd.TaskFive.model.unitFigure.Point;

public interface Strategy{
    double calculateTheArea(Point ... var);
    double calculateThePerimeter(Point ... var);
}
