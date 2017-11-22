package com.oleg.logic.triangles.trianglesKeeper;

import com.oleg.loggin.info.Info;
import com.oleg.logic.triangle.triangle.Triangle;
import com.oleg.logic.triangles.comparators.TrianglesKeeperByPerimetrComp;
import com.oleg.logic.triangles.comparators.TrianglesKeeperBySquareComp;

import java.util.HashMap;
import java.util.stream.Stream;

public class ViewGroups {


    public static void viewGroups(TrianglesKeeperManage keeper) {
        HashMap<Triangle, String> triangles = keeper.getSetsOfTriangles();

        String[] typesOfTriangle = {"equilateral triangle", "isosceles right triangle", "isosceles triangle", "arbitrary right triangle", "arbitrary triangle"};

        for (int i = 0; i < typesOfTriangle.length; i++) {
            if (triangles.containsValue(typesOfTriangle[i])) {
                Info.writeInfo(typesOfTriangle[i]);


                ViewGroups.findKey(triangles, typesOfTriangle[i]);

                ViewGroups.findMaxByPerimetr(triangles, typesOfTriangle[i]);
                ViewGroups.findMinByPerimetr(triangles, typesOfTriangle[i]);

                ViewGroups.findMaxBySquare(triangles, typesOfTriangle[i]);
                ViewGroups.findMinBySquare(triangles, typesOfTriangle[i]);
            }

        }
    }

    private static void findKey(HashMap<Triangle, String> map, String value) {
        map.entrySet().stream()
                .filter(element -> element.getValue().equals(value))
                .forEach(neededElement -> Info.writeInfo(neededElement.getKey().toString()));
    }

    private static void findMaxByPerimetr(HashMap<Triangle, String> map, String value) {
        TrianglesKeeperByPerimetrComp compareByPerimetr = new TrianglesKeeperByPerimetrComp();
        Stream<HashMap.Entry<Triangle, String>> rightElements = ViewGroups.getRightElements(map, value);
        HashMap.Entry<Triangle, String> maxElement = rightElements.max((element1, element2) -> compareByPerimetr.compare(element1.getKey(), element2.getKey())).get();
        Info.writeInfo("Maximum by perimetr: " + maxElement.getKey());


    }

    private static void findMinByPerimetr(HashMap<Triangle, String> map, String value) {
        TrianglesKeeperByPerimetrComp compareByPerimetr = new TrianglesKeeperByPerimetrComp();
        Stream<HashMap.Entry<Triangle, String>> rightElements = ViewGroups.getRightElements(map, value);
        HashMap.Entry<Triangle, String> minElement = rightElements.max((element1, element2) -> compareByPerimetr.compare(element1.getKey(), element2.getKey())).get();
        Info.writeInfo("Minimum by perimetr: " + minElement.getKey());

    }

    private static void findMaxBySquare(HashMap<Triangle, String> map, String value) {
        TrianglesKeeperBySquareComp compareBySquare = new TrianglesKeeperBySquareComp();
        Stream<HashMap.Entry<Triangle, String>> rightElements = ViewGroups.getRightElements(map, value);
        HashMap.Entry<Triangle, String> maxElement = rightElements.max((element1, element2) -> compareBySquare.compare(element1.getKey(), element2.getKey())).get();
        Info.writeInfo("Maximum by square: " + maxElement.getKey());

    }

    private static void findMinBySquare(HashMap<Triangle, String> map, String value) {
        TrianglesKeeperBySquareComp compareBySquare = new TrianglesKeeperBySquareComp();
        Stream<HashMap.Entry<Triangle, String>> rightElements = ViewGroups.getRightElements(map, value);
        HashMap.Entry<Triangle, String> minElement = rightElements.max((element1, element2) -> compareBySquare.compare(element1.getKey(), element2.getKey())).get();
        Info.writeInfo("Minimum by square: " + minElement.getKey());

    }

    private static Stream<HashMap.Entry<Triangle, String>> getRightElements(HashMap<Triangle, String> map, String value) {
        return map.entrySet()
                .stream()
                .filter(element -> element.getValue().equals(value));
    }


}
