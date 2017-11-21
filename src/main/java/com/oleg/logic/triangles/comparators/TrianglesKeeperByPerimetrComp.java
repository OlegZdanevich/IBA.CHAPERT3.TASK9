package com.oleg.logic.triangles.comparators;

import com.oleg.logic.triangle.triangle.Triangle;

import java.util.Comparator;

import static com.oleg.logic.triangle.triangle.TringleTools.getPerimetr;

public class TrianglesKeeperByPerimetrComp implements Comparator<Triangle> {

    public int compare(Triangle firstElement, Triangle secondElement) {
            if (getPerimetr(firstElement) > getPerimetr(secondElement)) {
                return 1;
            } else {
                return -1;
            }

    }
}
