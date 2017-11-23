package com.oleg.logic.triangle.triangle;

import com.oleg.logic.point.Point;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleToolsTest {
    private Triangle firstTriangle=null;
    private Triangle secondTriangle=null;
    private Triangle thirdTriangle=null;
    @Before
    public void setUp()
    {
        firstTriangle=new Triangle(new Point(1,1),new Point(2,1),new Point(1,2));
        secondTriangle=new Triangle(new Point(1,1),new Point(5,1),new Point(1,5));
        thirdTriangle=new Triangle(new Point(1,1),new Point(10,1),new Point(1,10));
    }

    @After
    public void tearDown()
    {
        firstTriangle=null;
        secondTriangle=null;
        thirdTriangle=null;

    }

    @Test
    public void getPerimetr() {
        assertEquals(2+Math.sqrt(2),TriangleTools.getPerimetr(firstTriangle),5);
        assertEquals(8+4*Math.sqrt(2),TriangleTools.getPerimetr(secondTriangle),5);
        assertEquals(18+9*Math.sqrt(2),TriangleTools.getPerimetr(thirdTriangle),5);

    }

    @Test
    public void getSquare() {
        assertEquals(1/2,TriangleTools.getSquare(firstTriangle),5);
        assertEquals(16/2,TriangleTools.getSquare(secondTriangle),5);
        assertEquals(81/2,TriangleTools.getSquare(thirdTriangle),5);
    }

}