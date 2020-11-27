package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

public interface Strategy{
    double calculateTheArea(Point ... var);
    double calculateThePerimeter(Point ... var);
}