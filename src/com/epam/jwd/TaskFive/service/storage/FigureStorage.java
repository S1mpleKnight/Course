package com.epam.jwd.TaskFive.service.storage;

import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.model.figures.Figure;
import com.epam.jwd.TaskFive.model.figures.MultiAngleFigure;
import com.epam.jwd.TaskFive.model.figures.Square;
import com.epam.jwd.TaskFive.model.figures.Triangle;
import com.epam.jwd.TaskFive.model.unitFigure.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class FigureStorage{
    private static final HashMap<Integer, Figure> FIGURES = new HashMap<>();
    private static int amountOfFigures = 0;
    private static FigureStorage singleStorage;

    private FigureStorage(){
    }

    public static FigureStorage getSingleStorage(){
        if (singleStorage == null){
            return new FigureStorage();
        } else {
            return singleStorage;
        }
    }

    public HashMap<Integer, Figure> takeFIGURES(){
        return FIGURES;
    }

    public Figure takeFigure(int ID){
        return FIGURES.get(ID);
    }

    void addFigureToStorage(GeometryUnitType type, Figure figure) throws FigureException{
        switch (type){
            case SQUARE:
                FIGURES.put(amountOfFigures, figure);
                amountOfFigures++;
                break;
            case TRIANGLE:
                FIGURES.put(amountOfFigures, figure);
                amountOfFigures++;
                break;
            case MULTI_ANGLE:
                FIGURES.put(amountOfFigures, figure);
                amountOfFigures++;
                break;
            case POINT:
            case LINE:
                throw new FigureException("Wrong type of figure");
            default:
                throw new FigureException("This type isn't exist");
        }
    }

    int findFigureByID(GeometryUnitType type, String name) throws FigureException{
        if (FIGURES.isEmpty()){
            return -1;
        } else {
            for (int i = 0; i < FIGURES.values().size(); i++){
                Figure x = FIGURES.get(i);
                switch (type){
                    case SQUARE:
                        if (((Square) x).getName().equals(name)){
                            return i;
                        }
                    case TRIANGLE:
                        if (((Triangle) x).getName().equals(name)){
                            return i;
                        }
                    case MULTI_ANGLE:
                        if (((MultiAngleFigure) x).getName().equals(name)){
                            return i;
                        }
                    case POINT:
                    case LINE:
                        throw new FigureException("Wrong type of figure");
                    default:
                        throw new FigureException("This type isn't exist");
                }
            }
        }
        return -1;
    }

    Figure findFigure(GeometryUnitType type, String name) throws FigureException{
        int pos = findFigureByID(type, name);
        return pos == -1 ? null : FIGURES.get(pos);
    }

    boolean deleteFigureInStorage(GeometryUnitType type, String name) throws FigureException{
        Optional<Figure> figure = Optional.of(findFigure(type, name));
        if (figure.isPresent()){
            switch (type){
                case SQUARE:
                case TRIANGLE:
                case MULTI_ANGLE:
                    FIGURES.remove(figure);
                    return true;
                case POINT:
                case LINE:
                    throw new FigureException("Wrong type of figure");
                default:
                    throw new FigureException("This type isn't exist");
            }
        } else {
            return false;
        }
    }

    Figure updateFigure(GeometryUnitType type, String name, ArrayList<Point> list, String newName) throws FigureException{
        Figure figure = findFigure(type, name);
        if (figure == null){
            return null;
        } else {
            switch (type){
                case SQUARE:
                    Square square = (Square) figure;
                    square.setFirstPoint(list.get(0));
                    square.setSecondPoint(list.get(1));
                    square.setThirdPoint(list.get(2));
                    square.setFourthPoint(list.get(3));
                    square.setName(newName);
                    break;
                case MULTI_ANGLE:
                    MultiAngleFigure multiAngle = (MultiAngleFigure) figure;
                    multiAngle.setAllPointsInFigure(list);
                    multiAngle.setName(newName);
                    break;
                case TRIANGLE:
                    Triangle triangle = (Triangle) figure;
                    triangle.setFirstPoint(list.get(0));
                    triangle.setSecondPoint(list.get(1));
                    triangle.setThirdPoint(list.get(2));
                    triangle.setName(newName);
                    break;
                case POINT:
                case LINE:
                    throw new FigureException("Wrong type of figure");
                default:
                    throw new FigureException("This type isn't exist");
            }
        }
        return figure;
    }
}
