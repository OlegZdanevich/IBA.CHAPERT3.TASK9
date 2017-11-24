package com.iba.task9.entity.point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    Point firstPoint=null;
    Point secondPoint=null;
    Point thirdPoint=null;

    @Before
    public void setUp() {
        firstPoint=new Point(1,2);
        secondPoint=new Point(1,3);
        thirdPoint=new Point(1,2);
    }

    @After
    public void tearDown() {
        firstPoint=null;
        secondPoint=null;
        thirdPoint=null;
    }

    @Test
    public void equals() {
        assertEquals(false,firstPoint.equals(secondPoint));
        assertEquals(true,firstPoint.equals(thirdPoint));
    }

    @Test
    public void toStringCheck() {
        assertEquals("{x: 1 ,y:2 }",firstPoint.toString());
        assertEquals("{x: 1 ,y:3 }",secondPoint.toString());
    }

}