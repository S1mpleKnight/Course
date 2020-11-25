package com.epam.jwd.model;

public class Square extends Triangle{
    private Point fourthPoint;

    public Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, String name){
        super(firstPoint, secondPoint, thirdPoint, name);
        this.fourthPoint = fourthPoint;

    }

    public Point getFourthPoint(){
        return fourthPoint;
    }

    @Override
    protected boolean validation() throws IllegalArgumentException{
        if (getFourthPoint().equals(getFirstPoint()) || getFourthPoint().equals(getSecondPoint())
                || getFourthPoint().equals(getThirdPoint()) || getThirdPoint().equals(getFirstPoint())
                || getThirdPoint().equals(getSecondPoint()) || getFirstPoint().equals(getSecondPoint())){
            throw new IllegalArgumentException("Объект -> " + toString() + "не является фигурой " + getClass().getName());
        } else {
            return true;
        }
    }

    @Override
    public String resultOfValidation() throws IllegalArgumentException{
        if (!validation()){
            return "Exception happened";
        } else if (!squareValidation()) {
            return "Exception happened";
        } else {
            return toString();
        }
    }

    @Override
    public String toString(){
        return "Square: " + getFirstPoint() + getSecondPoint() + getThirdPoint() + getFourthPoint();
    }

    private boolean squareValidation() throws IllegalArgumentException{
        int firstWidth = Math.abs(getSecondPoint().getX() - getFirstPoint().getX());
        int secondWidth = Math.abs(getFourthPoint().getX() - getThirdPoint().getX());
        int firstHeight = Math.abs(getFourthPoint().getY() - getFirstPoint().getY());
        int secondHeight = Math.abs(getThirdPoint().getY() - getSecondPoint().getY());
        if (firstHeight == secondHeight && firstWidth == secondWidth && firstHeight == firstWidth){
            return true;
        } else {
            throw new IllegalArgumentException("Объект " + toString() + "не является квадратом");
        }
    }
}
