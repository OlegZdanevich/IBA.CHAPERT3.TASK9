package com.iba.task9.tools.point;

import com.iba.task9.entity.point.Point;

public class PointTools
{
    public static double distanceBetweenTwoPoints(Point point1, Point point2)
    {
        return Math.hypot(point1.getX()-point2.getX(),point1.getY()-point2.getY());
    }
}
