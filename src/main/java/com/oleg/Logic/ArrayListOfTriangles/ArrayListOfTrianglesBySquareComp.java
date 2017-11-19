package com.oleg.Logic.ArrayListOfTriangles;

import com.oleg.Logic.Triangle.Triangle;

import java.util.Comparator;

public class ArrayListOfTrianglesBySquareComp implements Comparator<Triangle> {

    public int compare(Triangle firstElement, Triangle secondElement) {
        if (firstElement.getSquare() > secondElement.getSquare()) {
            return 1;
        } else {
            return -1;
        }

    }
}