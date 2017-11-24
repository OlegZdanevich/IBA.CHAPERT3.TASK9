package com.iba.task9.entity.triangle;

import com.iba.task9.entity.point.Point;
import com.iba.task9.tools.triangle.TypeAnalizerTools;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    private Triangle firstTriangle = null;
    private Triangle secondTriangle = null;
    private Triangle thirdTriangle = null;

    @Before
    public void setUp() {
        firstTriangle = new Triangle(new Point(1, 1), new Point(2, 1), new Point(1, 2));
        secondTriangle = new Triangle(new Point(1, 1), new Point(5, 1), new Point(1, 5));
        thirdTriangle = new Triangle(new Point(1, 1), new Point(2, 1), new Point(1, 2));
    }

    @After
    public void tearDown() {
        firstTriangle = null;
        secondTriangle = null;
        thirdTriangle = null;

    }

    @Test
    public void equals() {
        assertEquals(true,firstTriangle.equals(thirdTriangle));
        assertEquals(false,firstTriangle.equals(secondTriangle));
    }

    @Test
    public void toStringCheck()
    {
        assertEquals("{ {x: 1 ,y:1 } , {x: 2 ,y:1 } , {x: 1 ,y:2 } type: isosceles right triangle }",firstTriangle.toString());
        assertEquals("{ {x: 1 ,y:1 } , {x: 5 ,y:1 } , {x: 1 ,y:5 } type: isosceles right triangle }",secondTriangle.toString());
    }

}