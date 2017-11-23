package com.oleg.logic.triangles.trianglesKeeper;

import com.oleg.logic.triangle.triangle.Triangle;
import com.oleg.logic.triangle.typeAnalizer.GetType;
import com.oleg.observer.Observer;


import java.util.HashMap;


public class TrianglesKeeperManage implements Observer
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


    public void addElement(Triangle triangleToAdd)
    {
        String type= GetType.getTypeOfTringle(triangleToAdd);
        trianglesMap.put(triangleToAdd,type);

        triangleToAdd.registerObserver(this);
    }


    @Override
    public void update(Triangle oldTriangle,Triangle newTriangle) {
        trianglesMap.remove(oldTriangle);
        trianglesMap.put(newTriangle, GetType.getTypeOfTringle(newTriangle));
        ViewGroups.viewGroups(this);
    }

    public HashMap getSetsOfTriangles() {
        return trianglesMap;
    }
}
