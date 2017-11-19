package com.oleg.Logic.Triangle;

import com.oleg.Logic.Point.Point;
import com.oleg.Logic.Point.PointTools;


public class Triangle {
    private Point firstPoint = null;
    private Point secondPoint = null;
    private Point thirdPoint = null;

    private double lenghtOfFirstLine;
    private double lenghtOfSecondLine;
    private double lenghtOfThirdLine;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = new Point(firstPoint);
        this.secondPoint = new Point(secondPoint);
        this.thirdPoint = new Point(thirdPoint);

        this.lenghtOfFirstLine = PointTools.distanceBetweenTwoPoints(firstPoint, secondPoint);
        this.lenghtOfSecondLine = PointTools.distanceBetweenTwoPoints(secondPoint, thirdPoint);
        this.lenghtOfThirdLine = PointTools.distanceBetweenTwoPoints(thirdPoint, firstPoint);

    }

    Triangle(Triangle triangle)
    {
        this.firstPoint = new Point(triangle.firstPoint);
        this.secondPoint = new Point(triangle.secondPoint);
        this.thirdPoint = new Point(triangle.thirdPoint);

        this.lenghtOfFirstLine = PointTools.distanceBetweenTwoPoints(this.firstPoint, this.secondPoint);
        this.lenghtOfSecondLine = PointTools.distanceBetweenTwoPoints(this.secondPoint, this.thirdPoint);
        this.lenghtOfThirdLine = PointTools.distanceBetweenTwoPoints(this.thirdPoint, this.firstPoint);
    }

    public String getTypeOfTringle() {


        if (lenghtOfFirstLine == lenghtOfSecondLine & lenghtOfSecondLine == lenghtOfThirdLine) {
            return "equilateral triangle";
        }

        if (lenghtOfFirstLine == lenghtOfSecondLine || lenghtOfSecondLine == lenghtOfThirdLine || lenghtOfFirstLine == lenghtOfThirdLine) {
            if (isRightTriangle()) return "isosceles right triangle";
            return "isosceles triangle";
        }

        if (isRightTriangle()) return "arbitrary right triangle";

        return "arbitrary triangle";
    }

    public double getPerimetr() {
        return lenghtOfFirstLine + lenghtOfSecondLine + lenghtOfThirdLine;
    }

    public double getSquare() {
        double halfOfPerimetr = getPerimetr() / 2;

        return Math.sqrt(halfOfPerimetr * (halfOfPerimetr - lenghtOfFirstLine) * (halfOfPerimetr - lenghtOfSecondLine) * (halfOfPerimetr - lenghtOfThirdLine));
    }

    public boolean isRightTriangle() {
        double squareOfFirstLine = Math.pow(lenghtOfFirstLine, 2);
        double squareOfSecondLine = Math.pow(lenghtOfSecondLine, 2);
        double squareOfThirdLine = Math.pow(lenghtOfThirdLine, 2);

        if (Math.sqrt(squareOfFirstLine + squareOfSecondLine) == lenghtOfThirdLine) return true;
        if (Math.sqrt(squareOfFirstLine + squareOfThirdLine) == lenghtOfSecondLine) return true;
        if (Math.sqrt(squareOfSecondLine + squareOfThirdLine) == lenghtOfFirstLine) return true;

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (!firstPoint.equals(triangle.firstPoint)) return false;
        if (!secondPoint.equals(triangle.secondPoint)) return false;
        return thirdPoint.equals(triangle.thirdPoint);
    }

    @Override
    public int hashCode() {
        int result = firstPoint.hashCode();
        result = 31 * result + secondPoint.hashCode();
        result = 31 * result + thirdPoint.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{ "+firstPoint+" , "+secondPoint+" , "+thirdPoint+" type: "+getTypeOfTringle()+" }";
    }


}
