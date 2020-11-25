package com.epam.jwd.model;

public class Triangle extends Line{
    private Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint, String name){
        super(firstPoint, secondPoint, name);
        this.thirdPoint = thirdPoint;
    }

    public Point getThirdPoint(){
        return thirdPoint;
    }

    @Override
    protected boolean validation() throws IllegalArgumentException{
        if (getFirstPoint().equals(getSecondPoint()) || getFirstPoint().equals(getThirdPoint())
                || getSecondPoint().equals(getThirdPoint())){
            throw new IllegalArgumentException("Объект -> " + toString() + "не является фигурой " + getClass().getName());
        } else {
            return true;
        }
    }

    @Override
    public String resultOfValidation() throws IllegalArgumentException{
        if (!validation()){
            return "Exception happened";
        } else if (!triangleValidation()){              //3 points on 1 line
            return "Exception happened";
        } else {
            return toString();
        }
    }

    @Override
    public String toString(){
        return "Triangle: " + getFirstPoint().toString() + getSecondPoint().toString() + getThirdPoint().toString();
    }

    private boolean triangleValidation() throws IllegalArgumentException{
        double a = Point.destinationBetweenPoints(getFirstPoint(), getSecondPoint());
        double b = Point.destinationBetweenPoints(getSecondPoint(), getThirdPoint());
        double c = Point.destinationBetweenPoints(getThirdPoint(), getFirstPoint());
        if ((a + b) < c || (a + c) < b || (b + c) < a){
            throw new IllegalArgumentException("Треугольник " + toString() + "не может существовать");
        } else if (threePointsOnOneLine()){
            throw new IllegalArgumentException("Треугольник " + toString() + "не может существовать");
        } else {
            return true;
        }
    }

    private boolean threePointsOnOneLine(){
        double X = (double) (getFirstPoint().getX() - getSecondPoint().getX()) / (getThirdPoint().getX() - getSecondPoint().getX());
        double Y = (double) (getFirstPoint().getY() - getSecondPoint().getY()) / (getThirdPoint().getY() - getSecondPoint().getY());
        if (X == Y){
            return true;
        } else {
            return false;
        }
    }
}
