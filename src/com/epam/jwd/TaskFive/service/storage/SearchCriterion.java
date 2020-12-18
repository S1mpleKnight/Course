package com.epam.jwd.TaskFive.service.storage;

import com.epam.jwd.TaskFive.model.GeometryUnitType;
import com.epam.jwd.TaskFive.model.unitFigure.Point;

import java.util.Objects;

public class SearchCriterion{
    private final int range;
    private final int startIndex;
    private final String name;
    private final Point point;
    private final GeometryUnitType type;

    public SearchCriterion(int range, int startIndex, String name, Point point, GeometryUnitType type){
        this.range = range;
        this.startIndex = startIndex;
        this.name = name;
        this.point = point;
        this.type = type;
    }

    public int getRange(){
        return range;
    }

    public int getStartIndex(){
        return startIndex;
    }

    public String getName(){
        return name;
    }

    public Point getPoint(){
        return point;
    }

    public GeometryUnitType getType(){
        return type;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCriterion that = (SearchCriterion) o;
        return range == that.range &&
                startIndex == that.startIndex &&
                Objects.equals(name, that.name) &&
                Objects.equals(point, that.point) &&
                type == that.type;
    }

    @Override
    public int hashCode(){
        return Objects.hash(range, startIndex, name, point, type);
    }

    @Override
    public String toString(){
        return "SearchCriterion{" +
                "range=" + range +
                ", startIndex=" + startIndex +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", type=" + type +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int range;
        private int startIndex;
        private String name;
        private Point point;
        private GeometryUnitType type;

        public Builder range(int range){
            this.range = range;
            return this;
        }

        public Builder startIndex(int startIndex){
            this.startIndex = startIndex;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder point(Point point){
            this.point = point;
            return this;
        }

        public Builder type(GeometryUnitType type){
            this.type = type;
            return this;
        }

        public SearchCriterion build(){
            return new SearchCriterion(
                    this.range,
                    this.startIndex,
                    this.name,
                    this.point,
                    this.type);
        }
    }
}
