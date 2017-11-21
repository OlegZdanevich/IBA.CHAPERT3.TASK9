package com.oleg.logic.triangle.triangle;

import com.oleg.logic.point.Point;
import com.oleg.logic.point.PointTools;

import static com.oleg.logic.triangle.typeAnalizer.GetType.getTypeOfTringle;


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







    public double getLenghtOfFirstLine() {
        return lenghtOfFirstLine;
    }

    public double getLenghtOfSecondLine() {
        return lenghtOfSecondLine;
    }

    public double getLenghtOfThirdLine() {
        return lenghtOfThirdLine;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
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
        return "{ "+firstPoint+" , "+secondPoint+" , "+thirdPoint+" type: "+getTypeOfTringle(this)+" }";
    }


}
