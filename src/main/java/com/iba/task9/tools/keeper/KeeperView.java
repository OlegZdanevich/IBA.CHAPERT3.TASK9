package com.iba.task9.tools.keeper;

import com.iba.task9.loggin.info.Info;
import com.iba.task9.keeper.TrianglesKeeper;
import com.iba.task9.entity.triangle.Triangle;
import com.iba.task9.comparators.triangles.TriangleComparatorByPerimetr;
import com.iba.task9.comparators.triangles.TriangleComparatorBySquare;

import java.util.HashMap;
import java.util.stream.Stream;

public class KeeperView {


    public static void viewGroups(TrianglesKeeper keeper) {
        HashMap<Triangle, String> triangles = keeper.getSetsOfTriangles();

        String[] typesOfTriangle = {"equilateral triangle", "isosceles right triangle", "isosceles triangle", "arbitrary right triangle", "arbitrary triangle"};

        Info.writeInfo("*******************************");

        for (int i = 0; i < typesOfTriangle.length; i++) {
            if (triangles.containsValue(typesOfTriangle[i])) {
                Info.writeInfo(typesOfTriangle[i]);


                KeeperView.findElements(triangles, typesOfTriangle[i]);

                KeeperView.findMaxByPerimetr(triangles, typesOfTriangle[i]);
                KeeperView.findMinByPerimetr(triangles, typesOfTriangle[i]);

                KeeperView.findMaxBySquare(triangles, typesOfTriangle[i]);
                KeeperView.findMinBySquare(triangles, typesOfTriangle[i]);
            }

        }
    }

    private static void findElements(HashMap<Triangle, String> map, String value) {
        map.entrySet().stream()
                .filter(element -> element.getValue().equals(value))
                .forEach(neededElement -> Info.writeInfo(neededElement.getKey().toString()));
    }

    private static void findMaxByPerimetr(HashMap<Triangle, String> map, String value) {
        TriangleComparatorByPerimetr compareByPerimetr = new TriangleComparatorByPerimetr();

        Stream<HashMap.Entry<Triangle, String>> rightElements = KeeperView.getRightElements(map, value);
        HashMap.Entry<Triangle, String> maxElement = rightElements.max((element1, element2) -> compareByPerimetr.compare(element1.getKey(), element2.getKey())).get();

        Info.writeInfo("Maximum by perimetr: " + maxElement.getKey());


    }

    private static void findMinByPerimetr(HashMap<Triangle, String> map, String value) {
        TriangleComparatorByPerimetr compareByPerimetr = new TriangleComparatorByPerimetr();

        Stream<HashMap.Entry<Triangle, String>> rightElements = KeeperView.getRightElements(map, value);
        HashMap.Entry<Triangle, String> minElement = rightElements.min((element1, element2) -> compareByPerimetr.compare(element1.getKey(), element2.getKey())).get();

        Info.writeInfo("Minimum by perimetr: " + minElement.getKey());

    }

    private static void findMaxBySquare(HashMap<Triangle, String> map, String value) {
        TriangleComparatorBySquare compareBySquare = new TriangleComparatorBySquare();

        Stream<HashMap.Entry<Triangle, String>> rightElements = KeeperView.getRightElements(map, value);
        HashMap.Entry<Triangle, String> maxElement = rightElements.max((element1, element2) -> compareBySquare.compare(element1.getKey(), element2.getKey())).get();

        Info.writeInfo("Maximum by square: " + maxElement.getKey());

    }

    private static void findMinBySquare(HashMap<Triangle, String> map, String value) {
        TriangleComparatorBySquare compareBySquare = new TriangleComparatorBySquare();

        Stream<HashMap.Entry<Triangle, String>> rightElements = KeeperView.getRightElements(map, value);
        HashMap.Entry<Triangle, String> minElement = rightElements.min((element1, element2) -> compareBySquare.compare(element1.getKey(), element2.getKey())).get();

        Info.writeInfo("Minimum by square: " + minElement.getKey()+"\n\n\n");

    }

    private static Stream<HashMap.Entry<Triangle, String>> getRightElements(HashMap<Triangle, String> map, String value) {
        return map.entrySet()
                .stream()
                .filter(element -> element.getValue().equals(value));
    }


}
