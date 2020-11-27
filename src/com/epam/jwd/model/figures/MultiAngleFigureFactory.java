package com.epam.jwd.model.figures;

import com.epam.jwd.model.Point;

public class MultiAngleFigureFactory{
    private static MultiAngleFigure[] allCreatedMultiAngles = new MultiAngleFigure[4];
    private static int amountOfCreatedMultiAngles = 0;

    public static MultiAngleFigure createMultiAngleFigure(String name, int amountOfAngles, Point ...var){
        return takeFromCacheOrCreate(name, var, amountOfAngles);
    }

    private static MultiAngleFigure takeFromCacheOrCreate(String name, Point[] array, int amountOfPointsInFigure){
        for (MultiAngleFigure anotherFigure : allCreatedMultiAngles){
            if (anotherFigure != null && compareFigures(anotherFigure, amountOfPointsInFigure, array)){
                return anotherFigure;
            }
        }
        final MultiAngleFigure figure = new MultiAngleFigure(array, amountOfPointsInFigure, name);
        allCreatedMultiAngles[amountOfCreatedMultiAngles] = figure;
        amountOfCreatedMultiAngles++;
        return figure;
    }

    private static boolean compareFigures(MultiAngleFigure anotherFigure, int amountOfPointsInFigure, Point[] array){
        if (amountOfPointsInFigure == 4){
            return compareFourPointFigures(anotherFigure, array);
        } else if (amountOfPointsInFigure == 5){
            return compareFivePointFigures(anotherFigure, array);
        } else {
            return compareSixPointFigures(anotherFigure, array);
        }
    }

    private static boolean compareFourPointFigures(MultiAngleFigure figure, Point[] array){
        if (array.length != figure.getAmountOfPointsInFigure()){
            return false;
        }
        if (comparePointWithAnotherFour(figure.getAllPointsInFigure()[0], array[0], array[1], array[2], array[3])
                && comparePointWithAnotherFour(figure.getAllPointsInFigure()[1], array[0], array[1], array[2], array[3])
                && comparePointWithAnotherFour(figure.getAllPointsInFigure()[2], array[0], array[1], array[2], array[3])
                && comparePointWithAnotherFour(figure.getAllPointsInFigure()[3], array[0], array[1], array[2], array[3])){
            return true;
        } else {
            return false;
        }
    }


    private static boolean compareFivePointFigures(MultiAngleFigure figure, Point[] array){
        if (array.length != figure.getAmountOfPointsInFigure()){
            return false;
        }
        if (comparePointWithAnotherFive(figure.getAllPointsInFigure()[0], array[0], array[1], array[2], array[3], array[ 4])
                && comparePointWithAnotherFive(figure.getAllPointsInFigure()[1], array[0], array[1], array[2], array[3], array[4])
                && comparePointWithAnotherFive(figure.getAllPointsInFigure()[2], array[0], array[1], array[2], array[3], array[4])
                && comparePointWithAnotherFive(figure.getAllPointsInFigure()[3], array[0], array[1], array[2], array[3], array[4])
                && comparePointWithAnotherFive(figure.getAllPointsInFigure()[4], array[0], array[1], array[2], array[3], array[4])){
            return true;
        } else {
            return false;
        }
    }

    private static boolean compareSixPointFigures(MultiAngleFigure figure, Point[] array){
        if (array.length != figure.getAmountOfPointsInFigure()){
            return false;
        }
        if (comparePointWithAnotherSix(figure.getAllPointsInFigure()[0], array[0], array[1], array[2], array[3], array[4], array[5])
                && comparePointWithAnotherSix(figure.getAllPointsInFigure()[1], array[0], array[1], array[2], array[3], array[4], array[5])
                && comparePointWithAnotherSix(figure.getAllPointsInFigure()[2], array[0], array[1], array[2], array[3], array[4], array[5])
                && comparePointWithAnotherSix(figure.getAllPointsInFigure()[3], array[0], array[1], array[2], array[3], array[4], array[5])
                && comparePointWithAnotherSix(figure.getAllPointsInFigure()[4], array[0], array[1], array[2], array[3], array[4], array[5])
                && comparePointWithAnotherSix(figure.getAllPointsInFigure()[5], array[0], array[1], array[2], array[3], array[4], array[5])){
            return true;
        } else {
            return false;
        }
    }

    private static boolean comparePointWithAnotherFour(Point anotherPoint, Point firstPoint, Point secondPoint,
                                                       Point thirdPoint, Point fourthPoint){
        return (anotherPoint.equals(firstPoint) || anotherPoint.equals(secondPoint)
                || anotherPoint.equals(thirdPoint) || anotherPoint.equals(fourthPoint));
    }

    private static boolean comparePointWithAnotherFive(Point anotherPoint, Point firstPoint, Point secondPoint,
                                                       Point thirdPoint, Point fourthPoint, Point fifthPoint){
        return (anotherPoint.equals(firstPoint) || anotherPoint.equals(secondPoint)
                || anotherPoint.equals(thirdPoint) || anotherPoint.equals(fourthPoint)
                || anotherPoint.equals(fifthPoint));
    }

    private static boolean comparePointWithAnotherSix(Point anotherPoint, Point firstPoint, Point secondPoint,
                                                       Point thirdPoint, Point fourthPoint, Point fifthPoint,
                                                        Point sixthPoint){
        return (anotherPoint.equals(firstPoint) || anotherPoint.equals(secondPoint)
                || anotherPoint.equals(thirdPoint) || anotherPoint.equals(fourthPoint)
                || anotherPoint.equals(fifthPoint) || anotherPoint.equals(sixthPoint));
    }
}
