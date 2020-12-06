package com.epam.jwd.TaskThree.strategy;

import com.epam.jwd.TaskThree.model.simpleFigure.Point;

public interface Strategy{
    double calculateTheArea(Point ... var);
    double calculateThePerimeter(Point ... var);
}
