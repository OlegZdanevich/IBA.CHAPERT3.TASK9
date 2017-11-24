package com.iba.task9.keeper;

import com.iba.task9.observer.Observer;
import com.iba.task9.tools.keeper.KeeperView;
import com.iba.task9.tools.triangle.TypeAnalizerTools;
import com.iba.task9.entity.triangle.Triangle;


import java.util.HashMap;


public class TrianglesKeeper implements Observer
{
    private static volatile TrianglesKeeper instance;

    private HashMap<Triangle,String> trianglesMap=new HashMap<>();

    public static TrianglesKeeper getInstance() {
        TrianglesKeeper localInstance = instance;
        if (localInstance == null) {
            synchronized (TrianglesKeeper.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TrianglesKeeper();
                }
            }
        }
        return localInstance;
    }

    private TrianglesKeeper()
    { }


    public void addElement(Triangle triangleToAdd)
    {
        String type= TypeAnalizerTools.getTypeOfTringle(triangleToAdd);
        trianglesMap.put(triangleToAdd,type);

        triangleToAdd.registerObserver(this);
    }


    @Override
    public void update(Triangle oldTriangle,Triangle newTriangle) {
        trianglesMap.remove(oldTriangle);
        trianglesMap.put(newTriangle, TypeAnalizerTools.getTypeOfTringle(newTriangle));
        KeeperView.viewGroups(this);
    }

    public HashMap getSetsOfTriangles() {
        return trianglesMap;
    }
}
