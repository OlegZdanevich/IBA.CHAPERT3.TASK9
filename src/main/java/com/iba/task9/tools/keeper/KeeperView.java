package com.iba.task9.tools.keeper;

import com.iba.task9.comparators.triangles.TriangleComparatorByPerimetr;
import com.iba.task9.comparators.triangles.TriangleComparatorBySquare;
import com.iba.task9.entity.triangle.Triangle;
import com.iba.task9.keeper.triangles.TrianglesKeeper;
import com.iba.task9.keeper.types.TypesKeeper;
import com.iba.task9.loggin.info.Info;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

public class KeeperView {


    public static <K, V> void viewGroups(TrianglesKeeper keeper) {
        HashMap<K, V> triangles = keeper.getTrianglesMap();

        TypesKeeper trianglesTypes=keeper.getTypesKeeperOfTriangles();

        Info.writeInfo("*******************************");

        for(Object element: trianglesTypes)
        {
            V type=(V) element;
            Info.writeInfo((String) type);


            KeeperView.findElements(triangles, type);

            KeeperView.findMaxByPerimetr(triangles, type);
            KeeperView.findMinByPerimetr(triangles, type);

            KeeperView.findMaxBySquare(triangles, type);
            KeeperView.findMinBySquare(triangles, type);
        }





    }

    private static <K, V> void findElements(HashMap<K, V> map, V value) {
        map.entrySet().stream()
                .filter(element -> element.getValue().equals(value))
                .forEach(neededElement -> Info.writeInfo(neededElement.getKey().toString()));
    }

    private static <K, V> void findMaxByPerimetr(HashMap<K, V> map, V value) {
        TriangleComparatorByPerimetr compareByPerimetr = new TriangleComparatorByPerimetr();

        Stream<HashMap.Entry<K, V>> rightElements = KeeperView.getRightElements(map, value);
        HashMap.Entry<K, V> maxElement = rightElements.max((element1, element2) -> compareByPerimetr.compare((Triangle) element1.getKey(), (Triangle) element2.getKey())).get();

        Info.writeInfo("Maximum by perimetr: " + maxElement.getKey());


    }

    private static <K, V> void findMinByPerimetr(HashMap<K, V> map, V value) {
        TriangleComparatorByPerimetr compareByPerimetr = new TriangleComparatorByPerimetr();

        Stream<HashMap.Entry<K, V>> rightElements = KeeperView.getRightElements(map, value);
        HashMap.Entry<K, V> minElement = rightElements.min((element1, element2) -> compareByPerimetr.compare((Triangle) element1.getKey(), (Triangle) element2.getKey())).get();

        Info.writeInfo("Minimum by perimetr: " + minElement.getKey());

    }

    private static <K, V> void findMaxBySquare(HashMap<K, V> map, V value) {
        TriangleComparatorBySquare compareBySquare = new TriangleComparatorBySquare();

        Stream<HashMap.Entry<K, V>> rightElements = KeeperView.getRightElements(map, value);
        HashMap.Entry<K, V> maxElement = rightElements.max((element1, element2) -> compareBySquare.compare((Triangle) element1.getKey(), (Triangle) element2.getKey())).get();

        Info.writeInfo("Maximum by square: " + maxElement.getKey());

    }

    private static <K, V> void findMinBySquare(HashMap<K, V> map, V value) {
        TriangleComparatorBySquare compareBySquare = new TriangleComparatorBySquare();

        Stream<HashMap.Entry<K, V>> rightElements = KeeperView.getRightElements(map, value);
        HashMap.Entry<K, V> minElement = rightElements.min((element1, element2) -> compareBySquare.compare((Triangle) element1.getKey(), (Triangle) element2.getKey())).get();

        Info.writeInfo("Minimum by square: " + minElement.getKey() + "\n\n\n");

    }

    private static <K, V> Stream<HashMap.Entry<K, V>> getRightElements(HashMap<K, V> map, V value) {
        return map.entrySet()
                .stream()
                .filter(element -> element.getValue().equals(value));
    }


}
