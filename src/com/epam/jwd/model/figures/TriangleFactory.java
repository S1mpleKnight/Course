package com.epam.jwd.model.figures;

import com.epam.jwd.model.Point;

public class TriangleFactory{
    private static Triangle[] allCreatedTriangles = new Triangle[4];
    private static int amountOfCreatedTriangles = 0;

    public static Triangle createTriangle(Point firstPoint, Point secondPoint, Point thirdPoint, String name){
        return takeFromCacheOrCreate(firstPoint, secondPoint, thirdPoint, name);
    }

    private static Triangle takeFromCacheOrCreate(Point firstPoint, Point secondPoint, Point thirdPoint, String name){
        for (Triangle anotherTriangle : allCreatedTriangles){
            if (anotherTriangle != null && compareTriangles(anotherTriangle, firstPoint, secondPoint, thirdPoint)){
                return anotherTriangle;
            }
        }
        final Triangle triangle = new Triangle( firstPoint, secondPoint, thirdPoint, name);
        allCreatedTriangles[amountOfCreatedTriangles] = triangle;
        amountOfCreatedTriangles++;
        return triangle;
    }

    private static boolean compareTriangles(Triangle anotherTriangle, Point firstPoint, Point secondPoint, Point thirdPoint){
        if (comparePointWithAnotherThree(anotherTriangle.getFirstPoint(), firstPoint, secondPoint, thirdPoint)
        && comparePointWithAnotherThree(anotherTriangle.getSecondPoint(), firstPoint, secondPoint, thirdPoint)
        && comparePointWithAnotherThree(anotherTriangle.getThirdPoint(), firstPoint, secondPoint, thirdPoint)){
            return true;
        } else {
            return false;
        }
    }

    private static boolean comparePointWithAnotherThree(Point anotherPoint, Point firstPoint, Point secondPoint, Point thirdPoint){
        return (anotherPoint.equals(firstPoint) || anotherPoint.equals(secondPoint) || anotherPoint.equals(thirdPoint));
    }
}
