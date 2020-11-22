package com.epam.jwd.app;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.epam.jwd.model.Point;

class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        Point[] mas = new Point[5];
        Point nextPoint;
        for (int i = 0; i < mas.length; i++){
            nextPoint = new Point(i, i);
            mas[i] = nextPoint;
            logger.log(Level.INFO, "Result is: " + mas[i].toString());
	    System.out.println(mas[i].toString());
        }
    }
}
