package com.epam.jwd.model.figures;

import com.epam.jwd.model.Point;

public class SquareFactory{
    private static Square[] allCreatedSquares = new Square[2];
    private static int amountOfCreatedSquares = 0;

    public static Square createSquare(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, String name){
        return takeFromCacheOrCreate(firstPoint, secondPoint, thirdPoint, fourthPoint, name);
    }

    private static Square takeFromCacheOrCreate(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, String name){
        for (Square anotherSquare : allCreatedSquares){
            if (anotherSquare != null && compareSquares(anotherSquare, firstPoint, secondPoint, thirdPoint, fourthPoint)){
                return anotherSquare;
            }
        }
        final Square square = new Square(firstPoint, secondPoint, thirdPoint, fourthPoint, name);
        allCreatedSquares[amountOfCreatedSquares] = square;
        amountOfCreatedSquares++;
        return square;
    }

    private static boolean compareSquares(Square anotherSquare, Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint){
        if (comparePointWithAnotherFour(anotherSquare.getFirstPoint(), firstPoint, secondPoint, thirdPoint, fourthPoint)
                && comparePointWithAnotherFour(anotherSquare.getSecondPoint(), firstPoint, secondPoint, thirdPoint, fourthPoint)
                && comparePointWithAnotherFour(anotherSquare.getThirdPoint(), firstPoint, secondPoint, thirdPoint, fourthPoint)
                && comparePointWithAnotherFour(anotherSquare.getFourthPoint(), firstPoint, secondPoint, thirdPoint, fourthPoint)){
            return true;
        } else {
            return false;
        }
    }

    private static boolean comparePointWithAnotherFour(Point anotherPoint, Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint){
        return (anotherPoint.equals(firstPoint) || anotherPoint.equals(secondPoint)
                || anotherPoint.equals(thirdPoint) || anotherPoint.equals(fourthPoint));
    }
}
