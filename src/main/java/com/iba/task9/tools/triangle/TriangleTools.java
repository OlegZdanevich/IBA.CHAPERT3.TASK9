package com.iba.task9.tools.triangle;


import com.iba.task9.entity.triangle.Triangle;

public class TriangleTools
{

    public static double getPerimetr(Triangle triangle) {
        return triangle.getLenghtOfFirstLine() + triangle.getLenghtOfSecondLine() + triangle.getLenghtOfThirdLine();
    }

    public static double getSquare(Triangle triangle) {
        double halfOfPerimetr = getPerimetr(triangle) / 2;

        return Math.sqrt(halfOfPerimetr * (halfOfPerimetr - triangle.getLenghtOfFirstLine()) * (halfOfPerimetr - triangle.getLenghtOfSecondLine()) * (halfOfPerimetr - triangle.getLenghtOfThirdLine()));
    }

}
