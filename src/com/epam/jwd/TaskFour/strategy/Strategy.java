package com.epam.jwd.TaskFour.strategy;

import com.epam.jwd.TaskFour.model.simpleFigure.Point;

public interface Strategy{
    double calculateTheArea(Point ... var);
    double calculateThePerimeter(Point ... var);
}
