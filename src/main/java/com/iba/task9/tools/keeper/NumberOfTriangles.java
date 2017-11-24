package com.iba.task9.tools.keeper;

import com.iba.task9.keeper.triangles.TrianglesKeeper;

import java.util.HashMap;

public class NumberOfTriangles
{
    public static<K,V> long numberOfTrianglesInGroup(TrianglesKeeper keeper,V value)
    {
        HashMap<K, V> triangles = keeper.getTrianglesMap();
        long number=triangles.entrySet()
                .stream()
                .filter(element -> element.getValue().equals(value))
                .count();
        return number;
    }

}
