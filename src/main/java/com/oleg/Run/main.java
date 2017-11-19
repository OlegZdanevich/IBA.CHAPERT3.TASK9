package com.oleg.Run;

import com.oleg.Logic.ArrayListOfTriangles.ArrayListOfTriangles;
import com.oleg.Exceptions.Exceptions;
import com.oleg.Logic.Point.Point;
import com.oleg.Logic.Triangle.Triangle;


import java.util.Scanner;

public class main {
    private static Triangle[] arrayOfTriangles = null;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {

            System.out.print("Enter number of triangles: ");
            int numberOfTriangles = Integer.parseInt(input.next());

            if (numberOfTriangles <= 0) throw new IllegalArgumentException("Number of triangles should be greater then zero");

            arrayOfTriangles=new Triangle[numberOfTriangles];

            for (int i = 0; i < numberOfTriangles; i++) {
                System.out.println((i+1)+") triangle");
                arrayOfTriangles[i]=makeTriangle();
            }

            ArrayListOfTriangles trianglesByGroups=new ArrayListOfTriangles(arrayOfTriangles);

            trianglesByGroups.viewGroups();

        } catch (NumberFormatException exception) {
            Exceptions.notNumberException(exception);
        } catch (NullPointerException exception) {
            Exceptions.notInitializedException(exception);
        }
    }

    private static Triangle makeTriangle() throws NumberFormatException
    {
        System.out.println("First point: ");
        Point firstPoint=makePoint();

        System.out.println("Second point: ");
        Point secondPoint=makePoint();

        System.out.println("Third point: ");
        Point thirdPoint=makePoint();

        return new Triangle(firstPoint,secondPoint,thirdPoint);
    }

    private static Point makePoint() throws NumberFormatException
    {
        Scanner input=new Scanner(System.in);

        System.out.println("X:" );
        int x=Integer.parseInt(input.next());

        System.out.println("Y:" );
        int y=Integer.parseInt(input.next());

        return new Point(x,y);
    }
}

