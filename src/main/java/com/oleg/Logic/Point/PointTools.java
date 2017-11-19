package com.oleg.Logic.Point;

public abstract class PointTools
{
    public static double distanceBetweenTwoPoints(Point point1,Point point2)
    {
        return Math.sqrt(Math.pow(point1.getX()-point2.getX(),2)+Math.pow(point1.getY()-point2.getY(),2));
    }
}