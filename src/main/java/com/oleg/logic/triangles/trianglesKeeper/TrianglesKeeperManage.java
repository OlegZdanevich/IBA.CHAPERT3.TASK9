package com.oleg.logic.triangles.trianglesKeeper;

import com.oleg.loggin.exceptions.Exceptions;
import com.oleg.logic.point.Point;
import com.oleg.logic.triangle.triangle.Triangle;
import com.oleg.logic.triangle.typeAnalizer.GetType;


import java.util.HashMap;


public class TrianglesKeeperManage
{
    private static volatile TrianglesKeeperManage instance;

    private HashMap<Triangle,String> trianglesMap=new HashMap<>();

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
    { }


    public void setElements(Triangle... triangles)
    {
        try {

            if (triangles.length == 0) throw new NullPointerException("This method should have triangles");

            for(int i=0;i<triangles.length;i++)
            {
                String type= GetType.getTypeOfTringle(triangles[i]);
                trianglesMap.put(triangles[i],type);
            }
        }
        catch (NullPointerException exception) {

            Exceptions.noParametrException(exception);
            Exceptions.makeWarning(" Array will have only one triangle");

            trianglesMap.put(new Triangle(new Point(0,0),new Point(0,0),new Point(0,0)),"none");
        }


    }

    public HashMap getSetsOfTriangles() {
        return trianglesMap;
    }
}
