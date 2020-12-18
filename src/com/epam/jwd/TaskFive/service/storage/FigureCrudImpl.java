package com.epam.jwd.TaskFive.service.storage;

import com.epam.jwd.TaskFive.exception.DecoratorException;
import com.epam.jwd.TaskFive.exception.FigureException;
import com.epam.jwd.TaskFive.factory.FigureFactory;
import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.model.figures.Figure;
import com.epam.jwd.TaskFive.model.figures.MultiAngleFigure;
import com.epam.jwd.TaskFive.model.figures.SimpleApplicationContext;
import com.epam.jwd.TaskFive.model.figures.Square;
import com.epam.jwd.TaskFive.model.figures.Triangle;
import com.epam.jwd.TaskFive.model.unitFigure.Point;
import com.epam.jwd.TaskFive.service.api.FigureCrud;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FigureCrudImpl implements FigureCrud{
    private static final FigureStorage STORAGE = FigureStorage.getSingleStorage();
    private static FigureFactory FACTORY;
    private static final Logger LOGGER = LogManager.getLogger(FigureCrudImpl.class.getName());
    private static FigureCrudImpl figureCrud;

    static{
        try{
            FACTORY = (new SimpleApplicationContext()).createFigureFactory();
        } catch (DecoratorException e){
            LOGGER.log(Level.FATAL, e.getMessage());
        }
    }

    private FigureCrudImpl(){
    }

    public static FigureCrud getFigureCrud(){
        if (figureCrud == null ){
            figureCrud = new FigureCrudImpl();
        }
        return figureCrud;
    }

    @Override
    public Figure createFigure(GeometryUnitType type, String name, List<Point> list) throws FigureException{
        Figure figure = FACTORY.createFigure(type, name, list);
        STORAGE.addFigureToStorage(type, figure);
        return figure;
    }

    @Override
    public List<Figure> multiCreateFigure(GeometryUnitType type, String[] names, List<Point> list) throws FigureException{
        List<Figure> figureList = new ArrayList<>();
        switch (type){
            case SQUARE:
                int i = 0;
                for (String name: names){
                    figureList.add(createFigure(type, name, list.subList(i, i + 4)));
                    i += 4;
                }
                return figureList;
            case MULTI_ANGLE:
                int j = 0, n;
                n = list.size() / names;
                for (String name: names){
                    figureList.add(createFigure(type, name, list.subList(j, j + n)));
                    j += n;
                }
                return figureList;
            case TRIANGLE:
                int k = 0;
                for (String name: names){
                    figureList.add(createFigure(type, name, list.subList(k, k + 3)));
                    k += 3;
                }
                return figureList;
            case POINT:
            case LINE:
                throw new FigureException("Wrong type of figure");
            default:
                throw new FigureException("This type isn't exist");
        }
    }

    @Override
    public Figure findFigure(GeometryUnitType type, String name) throws FigureException{
        return STORAGE.findFigure(type, name);
    }


    @Override
    public List<Figure> findByCriterion(SearchCriterion criterion) throws FigureException{
        List<Figure> list = checkInterval(criterion);
        list = typeCheck(criterion, list);
        list = pointCheck(criterion, list);
        return nameCheck(criterion, list);
    }

    private List<Figure> nameCheck(SearchCriterion criterion, List<Figure> list){
        if (criterion.getName() == null){
            return list;
        } else {
            List<Figure> anotherList = new ArrayList<>();
            for (Figure figure: list){
                if (figure.getName().equals(criterion.getName())){
                    anotherList.add(figure);
                }
            }
            return anotherList;
        }
    }

    private List<Figure> pointCheck(SearchCriterion criterion, List<Figure> list) throws FigureException{
        if (criterion.getPoint() == null){
            return list;
        } else {
            List<Figure> anotherList = new ArrayList<>();
            for (Figure figure: list){
                if (figure instanceof Triangle){
                    if (((Triangle) figure).containPoint(criterion.getPoint())){
                        anotherList.add(figure);
                    }
                } else if (figure instanceof Square){
                    if (((Square) figure).containPoint(criterion.getPoint())){
                        anotherList.add(figure);
                    };
                } else if (figure instanceof MultiAngleFigure){
                    if (((MultiAngleFigure) figure).containPoint(criterion.getPoint())){
                        anotherList.add(figure);
                    }
                } else {
                    throw new FigureException("Point check mistake");
                }
            }
            return anotherList;
        }
    }

    private List<Figure> typeCheck(SearchCriterion criterion, List<Figure> list) throws FigureException{
        if (criterion.getType() == null){
            return list;
        } else {
            List<Figure> anotherList = new ArrayList<>();
            for (Figure figure : list){
                switch (criterion.getType()){
                    case MULTI_ANGLE:
                        if (figure instanceof MultiAngleFigure){
                            anotherList.add(figure);
                        }
                        break;
                    case SQUARE:
                        if (figure instanceof Square){
                            anotherList.add(figure);
                        }
                        break;
                    case TRIANGLE:
                        if (figure instanceof Triangle){
                            anotherList.add(figure);
                        }
                        break;
                    case LINE:
                    case POINT:
                        throw new FigureException("Type check mistake: Wrong type");
                    default:
                        throw new FigureException("Type check mistake");
                }
            }
            return anotherList;
        }
    }

    private List<Figure> checkInterval(SearchCriterion criterion){
        List<Figure> interval = new ArrayList<>();
        if (criterion.getRange() != 0){
            for (int i = criterion.getStartIndex(); i < criterion.getStartIndex() + criterion.getRange(); i++){
                interval.add(STORAGE.takeFigure(i));
            }
        } else if (criterion.getStartIndex() != 0){
            interval = STORAGE.takeFIGURES().values()
                    .stream()
                    .skip(criterion.getStartIndex())
                    .collect(Collectors.toList());
        } else {
            interval.addAll(STORAGE.takeFIGURES().values());
        }
        return interval;
    }

    @Override
    public Figure updateFigure(GeometryUnitType type, String name, ArrayList<Point> list, String newName) throws FigureException{
        return STORAGE.updateFigure(type, name, list, newName);
    }

    @Override
    public void deleteFigure(GeometryUnitType type, String name) throws FigureException{
        STORAGE.deleteFigureInStorage(type, name);
    }
}
