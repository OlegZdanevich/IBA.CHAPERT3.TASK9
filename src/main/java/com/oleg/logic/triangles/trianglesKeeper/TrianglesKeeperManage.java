package com.oleg.logic.triangles.trianglesKeeper;

import com.oleg.exceptions.Exceptions;
import com.oleg.logic.point.Point;
import com.oleg.logic.triangle.triangle.Triangle;
import com.oleg.logic.triangle.typeAnalizer.GetType;


import java.util.ArrayList;
import java.util.HashSet;

public class TrianglesKeeperManage
{
    private static volatile TrianglesKeeperManage instance;

    private HashSet<Triangle>[] setsOfTriangles=new HashSet[5];

    public static TrianglesKeeperManage getInstance() {
        TrianglesKeeperManage localInstance = instance;
        if (localInstance == null) {
            synchronized (TrianglesKeeperManage.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TrianglesKeeperManage();
                }
            }
        }
        return localInstance;
    }

    private TrianglesKeeperManage()
    {
        for(int i=0;i<setsOfTriangles.length;i++)
        {
            setsOfTriangles[i]=new HashSet<>();
        }
    }


    public void setElements(Triangle... triangles)
    {
        try {



            if (triangles.length == 0) throw new NullPointerException("This method should have triangles");

            for(int i=0;i<triangles.length;i++)
            {
                String type= GetType.getTypeOfTringle(triangles[i]);

                switch (type)
                {
                    case "equilateral triangle":
                        setsOfTriangles[0].add(triangles[i]);
                        break;

                    case "isosceles right triangle":
                        setsOfTriangles[1].add(triangles[i]);
                        break;

                    case "isosceles triangle":
                        setsOfTriangles[2].add(triangles[i]);
                        break;

                    case "arbitrary right triangle":
                        setsOfTriangles[3].add(triangles[i]);
                        break;

                    case "arbitrary triangle":
                        setsOfTriangles[4].add(triangles[i]);
                        break;
                }
            }
        }
        catch (NullPointerException exception) {

            Exceptions.noParametrException(exception);
            Exceptions.makeWarning(" Array will have only one triangle");

            setsOfTriangles[0].add(new Triangle(new Point(0,0),new Point(0,0),new Point(0,0)));
        }


    }

    public HashSet<Triangle>[] getSetsOfTriangles() {
        return setsOfTriangles;
    }
}
