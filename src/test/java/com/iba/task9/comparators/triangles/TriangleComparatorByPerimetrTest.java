package com.iba.task9.comparators.triangles;

import com.iba.task9.entity.point.Point;
import com.iba.task9.entity.triangle.Triangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleComparatorByPerimetrTest {
    private Triangle firstTriangle = null;
    private Triangle secondTriangle = null;
    private Triangle thirdTriangle = null;

    private TriangleComparatorByPerimetr comparatorPerimetr = null;

    @Before
    public void setUp() {
        firstTriangle = new Triangle(new Point(1, 1), new Point(2, 1), new Point(1, 2));
        secondTriangle = new Triangle(new Point(1, 1), new Point(5, 1), new Point(1, 5));
        thirdTriangle = new Triangle(new Point(1, 1), new Point(10, 1), new Point(1, 10));

        comparatorPerimetr = new TriangleComparatorByPerimetr();
    }

    @After
    public void tearDown() {
        firstTriangle = null;
        secondTriangle = null;
        thirdTriangle = null;

        comparatorPerimetr = null;
    }

    @Test
    public void compare() {
        assertEquals(-1, comparatorPerimetr.compare(firstTriangle, secondTriangle));
        assertEquals(-1, comparatorPerimetr.compare(firstTriangle, thirdTriangle));
        assertEquals(-1, comparatorPerimetr.compare(secondTriangle, thirdTriangle));

        assertEquals(1, comparatorPerimetr.compare(thirdTriangle, firstTriangle));
        assertEquals(1, comparatorPerimetr.compare(thirdTriangle, secondTriangle));
        assertEquals(1, comparatorPerimetr.compare(secondTriangle, firstTriangle));
    }

}