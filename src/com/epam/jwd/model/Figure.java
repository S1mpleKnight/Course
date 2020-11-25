package com.epam.jwd.model;

public abstract class Figure{

    public abstract Point getFirstPoint();

    public abstract Point getSecondPoint();

    protected abstract boolean validation();

    public abstract String resultOfValidation();
}
