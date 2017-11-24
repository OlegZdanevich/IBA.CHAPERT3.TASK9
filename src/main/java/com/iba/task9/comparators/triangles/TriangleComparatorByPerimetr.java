package com.iba.task9.comparators.triangles;

import com.iba.task9.entity.triangle.Triangle;
import com.iba.task9.tools.triangle.TriangleTools;

import java.util.Comparator;

public class TriangleComparatorByPerimetr implements Comparator<Triangle> {

    public int compare(Triangle firstElement, Triangle secondElement) {
            if (TriangleTools.getPerimetr(firstElement) > TriangleTools.getPerimetr(secondElement)) {
                return 1;
            } else {
                return -1;
            }

    }


}