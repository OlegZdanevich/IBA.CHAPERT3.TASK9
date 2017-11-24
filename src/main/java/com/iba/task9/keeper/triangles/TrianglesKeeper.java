package com.iba.task9.keeper.triangles;

import com.iba.task9.keeper.types.TypesKeeper;
import com.iba.task9.loggin.exceptions.Exceptions;
import com.iba.task9.observer.Observer;
import com.iba.task9.tools.keeper.KeeperView;
import com.iba.task9.tools.keeper.NumberOfTriangles;
import com.iba.task9.tools.triangle.TypeAnalizerTools;
import com.iba.task9.entity.triangle.Triangle;


import java.util.HashMap;
import java.util.HashSet;


public class TrianglesKeeper<K,V> implements Observer<K>
{
    private static volatile TrianglesKeeper instance;

    private HashMap<K,V> trianglesMap=new HashMap<>();
    private TypesKeeper<V> typesKeeperOfTriangles =new TypesKeeper<>();

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


    public void addElement(K triangleToAdd)
    {
        try {
            Triangle triangle= (Triangle) triangleToAdd;
            V type= (V) TypeAnalizerTools.getTypeOfTringle(triangle);

            tryToAdd(type);

            trianglesMap.put(triangleToAdd,type);

            triangle.registerObserver(this);
        }
        catch (ClassCastException exception)
        {
            Exceptions.classCastException(exception);
        }

    }


    @Override
    public void update(K oldTriangle,K newTriangle) {
        try {
            trianglesMap.remove(oldTriangle);

            V typeOfNewTriangle= (V) TypeAnalizerTools.getTypeOfTringle((Triangle) newTriangle);
            V typeOfOldTriangle= (V) TypeAnalizerTools.getTypeOfTringle((Triangle) oldTriangle);

            if(NumberOfTriangles.numberOfTrianglesInGroup(this,typeOfOldTriangle)==1 ||NumberOfTriangles.numberOfTrianglesInGroup(this,typeOfOldTriangle)==0)
            {
                typesKeeperOfTriangles.deleteElement(typeOfOldTriangle);
            }

            tryToAdd(typeOfNewTriangle);

            trianglesMap.put(newTriangle,typeOfNewTriangle );
            KeeperView.viewGroups(this);
        }
        catch (ClassCastException exception)
        {
            Exceptions.classCastException(exception);
        }

    }

    public TypesKeeper<V> getTypesKeeperOfTriangles() {
        return typesKeeperOfTriangles;
    }

    public HashMap<K, V> getTrianglesMap() {
        return trianglesMap;
    }

    private void tryToAdd(V type)
    {
        if(!isContainsInTypes(type))
        {
            typesKeeperOfTriangles.addElement(type);
        }
    }

    private boolean isContainsInTypes(V type)
    {
        HashSet<V> setOfTypes= typesKeeperOfTriangles.getTypes();
        boolean result=(setOfTypes.contains(type))?true:false;

        return result;
    }
}
