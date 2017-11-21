package com.oleg.logic.triangles.trianglesKeeper;

import com.oleg.logic.triangle.triangle.Triangle;
import com.oleg.logic.triangles.comparators.TrianglesKeeperByPerimetrComp;
import com.oleg.logic.triangles.comparators.TrianglesKeeperBySquareComp;

import java.util.ArrayList;
import java.util.HashSet;

public class ViewGroups {
    public static void viewGroups(TrianglesKeeperManage keeper)
    {
       HashSet<Triangle> arrayListsOfTriangles[]=keeper.getSetsOfTriangles();

        String[] typesOfTriangle={"equilateral triangle","isosceles right triangle","isosceles triangle","arbitrary right triangle","arbitrary triangle"};

        for (int i=0;i<typesOfTriangle.length;i++)
        {
            if(arrayListsOfTriangles[i].size()==0) continue;

            System.out.println("Group: "+typesOfTriangle[i]);
            for(Triangle triangle: arrayListsOfTriangles[i])
            {
                System.out.println("     "+triangle);
            }

            ArrayList<Triangle> trianglesOfThisGroup=new ArrayList<>();
            trianglesOfThisGroup.addAll(arrayListsOfTriangles[i]);

            trianglesOfThisGroup.sort(new TrianglesKeeperByPerimetrComp());
            System.out.println("Max by perimetr: "+ trianglesOfThisGroup.get(trianglesOfThisGroup.size()-1));
            System.out.println("Min by perimetr: "+ trianglesOfThisGroup.get(0));

            trianglesOfThisGroup.sort(new TrianglesKeeperBySquareComp());
            System.out.println("Max by square: "+ trianglesOfThisGroup.get(trianglesOfThisGroup.size()-1));
            System.out.println("Min by square: "+ trianglesOfThisGroup.get(0));
        }
    }


}
