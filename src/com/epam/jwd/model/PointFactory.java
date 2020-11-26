package com.epam.jwd.model;

public class PointFactory{
    private static Point[] allCreatedPoints = new Point[8];
    private static int amountOfCreatedPoints = 0;

    private static Point takeFromCacheOrCreate(int x, int y, String name){
        for (Point anotherPoint : allCreatedPoints){
            if (anotherPoint != null && anotherPoint.getX() == x && anotherPoint.getY() == y){
                return anotherPoint;
            }
        }
        final Point point = new Point(x, y, name);
        allCreatedPoints[amountOfCreatedPoints] = point;
        amountOfCreatedPoints++;
        return point;
    }

    public static Point createPoint(int x, int y, String name){
        final Point point = takeFromCacheOrCreate(x, y , name);
        return point;
    }
}
