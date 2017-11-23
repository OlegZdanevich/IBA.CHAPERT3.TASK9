package com.oleg.entity.point;

public class PointTools
{
    public static double distanceBetweenTwoPoints(Point point1,Point point2)
    {
        return Math.hypot(point1.getX()-point2.getX(),point1.getY()-point2.getY());
    }
}
