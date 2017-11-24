package com.iba.task9.tools.triangle;

import com.iba.task9.entity.point.Point;

public class TriangleValidator
{
    public static boolean isTheTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        boolean result = true;

        if (firstPoint .equals(secondPoint) || secondPoint.equals(thirdPoint) || firstPoint.equals(thirdPoint)) {
            result = false;
        }

        if (firstPoint.getX() == secondPoint.getX() & secondPoint.getX() == thirdPoint.getX() & firstPoint.getX() == thirdPoint.getX()) {
            result = false;
        }

        if (firstPoint.getY() == secondPoint.getY() & secondPoint.getY() == thirdPoint.getY() & firstPoint.getY() == thirdPoint.getY()) {
            result = false;
        }

        return result;
    }
}
