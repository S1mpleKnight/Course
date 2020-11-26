package com.epam.jwd.model;

public class LineFactory{
    private static Line[] allCreatedLines = new Line[4];
    private static int amountOfCreatedLines = 0;

    public static Line createLine(Point firstPoint, Point secondPoint, String name){
        return takeFromCacheOrCreate(firstPoint, secondPoint, name);
    }

    private static Line takeFromCacheOrCreate(Point firstPoint, Point secondPoint, String name){
        for (Line anotherLine : allCreatedLines){
            if (anotherLine != null && isLineEquals(anotherLine, firstPoint, secondPoint)){
                return anotherLine;
            }
        }
        final Line line = new Line(firstPoint, secondPoint, name);
        allCreatedLines[amountOfCreatedLines] = line;
        amountOfCreatedLines++;
        return line;
    }

    private static boolean isLineEquals(Line anotherLine, Point firstPoint, Point secondPoint){
        if (anotherLine.getFirstPoint().equals(firstPoint) && anotherLine.getSecondPoint().equals(secondPoint)){
            return true;
        } else if (anotherLine.getFirstPoint().equals(secondPoint) && anotherLine.getSecondPoint().equals(firstPoint)){
            return true;
        } else {
            return false;
        }
    }
}
