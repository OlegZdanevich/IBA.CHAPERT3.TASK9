package com.iba.task9.comparators.triangles;

import com.iba.task9.entity.point.Point;
import com.iba.task9.entity.triangle.Triangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleComparatorBySquareTest {
    private Triangle firstTriangle=null;
    private Triangle secondTriangle=null;
    private Triangle thirdTriangle=null;

    private TriangleComparatorByPerimetr comparatorSquare=null;

    @Before
    public void setUp(){
        firstTriangle=new Triangle(new Point(1,1),new Point(2,1),new Point(1,2));
        secondTriangle=new Triangle(new Point(1,1),new Point(5,1),new Point(1,5));
        thirdTriangle=new Triangle(new Point(1,1),new Point(10,1),new Point(1,10));

        comparatorSquare=new TriangleComparatorByPerimetr();
    }

    @After
    public void tearDown() {
        firstTriangle=null;
        secondTriangle=null;
        thirdTriangle=null;

        comparatorSquare=null;
    }

    @Test
    public void compare() {
        assertEquals(-1,comparatorSquare.compare(firstTriangle,secondTriangle));
        assertEquals(-1,comparatorSquare.compare(firstTriangle,thirdTriangle));
        assertEquals(-1,comparatorSquare.compare(secondTriangle,thirdTriangle));

        assertEquals(1,comparatorSquare.compare(thirdTriangle,firstTriangle));
        assertEquals(1,comparatorSquare.compare(thirdTriangle,secondTriangle));
        assertEquals(1,comparatorSquare.compare(secondTriangle,firstTriangle));
    }

}