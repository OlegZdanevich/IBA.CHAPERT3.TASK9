package com.oleg.logic.triangles.trianglesKeeper;

import com.oleg.loggin.info.Info;
import com.oleg.logic.triangle.triangle.Triangle;
import com.oleg.logic.triangles.comparators.TrianglesKeeperByPerimetrComp;
import com.oleg.logic.triangles.comparators.TrianglesKeeperBySquareComp;

import java.util.*;

public class ViewGroups {


    public static void viewGroups(TrianglesKeeperManage keeper)
    {
       HashMap<Triangle,String> triangles=keeper.getSetsOfTriangles();

        String[] typesOfTriangle={"equilateral triangle","isosceles right triangle","isosceles triangle","arbitrary right triangle","arbitrary triangle"};

        for (int i=0;i<typesOfTriangle.length;i++)
        {
            ViewGroups.findKey(triangles,typesOfTriangle[i]);
        }
    }

    private static <K, V> void findKey(HashMap<K, V> map, V value) {
        map.entrySet().stream()
                .filter(element -> element.getValue().equals(value))
                .forEach(neededElement -> Info.writeInfo(neededElement.getKey().toString()));
    }

}
