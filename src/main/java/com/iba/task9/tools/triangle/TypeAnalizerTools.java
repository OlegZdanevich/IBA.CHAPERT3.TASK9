package com.iba.task9.tools.triangle;

import com.iba.task9.entity.point.Point;
import com.iba.task9.entity.triangle.Triangle;

public class TypeAnalizerTools {
    public static String getTypeOfTringle(Triangle triangle) {


        if (triangle.getLenghtOfFirstLine() == triangle.getLenghtOfSecondLine() & triangle.getLenghtOfSecondLine() == triangle.getLenghtOfThirdLine()) {
            return "equilateral triangle";
        }

        if (triangle.getLenghtOfFirstLine() == triangle.getLenghtOfSecondLine() || triangle.getLenghtOfSecondLine() == triangle.getLenghtOfThirdLine() ||
                triangle.getLenghtOfFirstLine() == triangle.getLenghtOfThirdLine()) {

            if (isRightTriangle(triangle)) return "isosceles right triangle";
            return "isosceles triangle";
        }

        if (isRightTriangle(triangle)) return "arbitrary right triangle";

        return "arbitrary triangle";
    }

    public static boolean isRightTriangle(Triangle triangle) {
        double squareOfFirstLine = Math.pow(triangle.getLenghtOfFirstLine(), 2);
        double squareOfSecondLine = Math.pow(triangle.getLenghtOfSecondLine(), 2);
        double squareOfThirdLine = Math.pow(triangle.getLenghtOfThirdLine(), 2);

        if (Math.sqrt(squareOfFirstLine + squareOfSecondLine) == triangle.getLenghtOfThirdLine()) return true;
        if (Math.sqrt(squareOfFirstLine + squareOfThirdLine) == triangle.getLenghtOfSecondLine()) return true;
        if (Math.sqrt(squareOfSecondLine + squareOfThirdLine) == triangle.getLenghtOfFirstLine()) return true;

        return false;
    }

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
