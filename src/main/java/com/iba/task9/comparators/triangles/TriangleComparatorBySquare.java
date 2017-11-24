package com.iba.task9.comparators.triangles;

import com.iba.task9.entity.triangle.Triangle;
import com.iba.task9.tools.triangle.TriangleTools;

import java.util.Comparator;

public class TriangleComparatorBySquare implements Comparator<Triangle> {

    public int compare(Triangle firstElement, Triangle secondElement) {
        int result = (TriangleTools.getSquare(firstElement) > TriangleTools.getSquare(secondElement)) ? 1 : -1;
        return result;

    }
}