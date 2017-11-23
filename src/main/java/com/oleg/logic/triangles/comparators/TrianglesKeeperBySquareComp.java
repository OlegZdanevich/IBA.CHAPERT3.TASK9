package com.oleg.logic.triangles.comparators;

import com.oleg.logic.triangle.triangle.Triangle;

import java.util.Comparator;

import static com.oleg.logic.triangle.triangle.TriangleTools.getSquare;

public class TrianglesKeeperBySquareComp implements Comparator<Triangle> {

    public int compare(Triangle firstElement, Triangle secondElement) {
        if (getSquare(firstElement) > getSquare(secondElement)) {
            return 1;
        } else {
            return -1;
        }

    }
}