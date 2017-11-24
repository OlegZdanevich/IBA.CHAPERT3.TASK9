package com.iba.task9.entity.triangle;

import com.iba.task9.entity.point.Point;
import com.iba.task9.loggin.exceptions.Exceptions;
import com.iba.task9.observer.Observable;
import com.iba.task9.observer.Observer;
import com.iba.task9.tools.point.PointTools;
import com.iba.task9.tools.triangle.TriangleValidator;
import com.iba.task9.tools.triangle.TypeAnalizerTools;

import java.util.LinkedList;
import java.util.List;


public class Triangle implements Observable {
    private Point firstPoint = null;
    private Point secondPoint = null;
    private Point thirdPoint = null;

    private double lenghtOfFirstLine;
    private double lenghtOfSecondLine;
    private double lenghtOfThirdLine;

    private List<Observer> observers;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) throws IllegalArgumentException {


        if (!TriangleValidator.isTheTriangle(firstPoint, secondPoint, thirdPoint)) {
            throw new IllegalArgumentException("This in not triangle");
        }
        this.firstPoint = new Point(firstPoint);
        this.secondPoint = new Point(secondPoint);
        this.thirdPoint = new Point(thirdPoint);

        this.lenghtOfFirstLine = PointTools.distanceBetweenTwoPoints(firstPoint, secondPoint);
        this.lenghtOfSecondLine = PointTools.distanceBetweenTwoPoints(secondPoint, thirdPoint);
        this.lenghtOfThirdLine = PointTools.distanceBetweenTwoPoints(thirdPoint, firstPoint);


        observers = new LinkedList<>();


    }

    Triangle(Triangle triangle) {
        this.firstPoint = new Point(triangle.firstPoint);
        this.secondPoint = new Point(triangle.secondPoint);
        this.thirdPoint = new Point(triangle.thirdPoint);

        this.lenghtOfFirstLine = PointTools.distanceBetweenTwoPoints(this.firstPoint, this.secondPoint);
        this.lenghtOfSecondLine = PointTools.distanceBetweenTwoPoints(this.secondPoint, this.thirdPoint);
        this.lenghtOfThirdLine = PointTools.distanceBetweenTwoPoints(this.thirdPoint, this.firstPoint);

        observers = new LinkedList<>();
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
        return "{ " + firstPoint + " , " + secondPoint + " , " + thirdPoint + " type: " + TypeAnalizerTools.getTypeOfTringle(this) + " }";
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Triangle oldTriangle, Triangle newTriangle) {
        for (Observer observer : observers)
            observer.update(oldTriangle, newTriangle);
    }

    public boolean setPoints(Point firstPoint, Point secondPoint, Point thirdPoint) {

        try {
            if (!TriangleValidator.isTheTriangle(firstPoint, secondPoint, thirdPoint))
                throw new IllegalArgumentException("This is not triangle");
            Triangle oldTriangle = new Triangle(this);
            Triangle newTriangle = new Triangle(firstPoint, secondPoint, thirdPoint);


            notifyObservers(oldTriangle, newTriangle);

            this.firstPoint = new Point(firstPoint);
            this.secondPoint = new Point(secondPoint);
            this.thirdPoint = new Point(thirdPoint);

            this.lenghtOfFirstLine = PointTools.distanceBetweenTwoPoints(firstPoint, secondPoint);
            this.lenghtOfSecondLine = PointTools.distanceBetweenTwoPoints(secondPoint, thirdPoint);
            this.lenghtOfThirdLine = PointTools.distanceBetweenTwoPoints(thirdPoint, firstPoint);

            return true;
        } catch (IllegalArgumentException exception) {
            Exceptions.notCorrectNumbersException(exception);
            return false;
        }


    }
}
