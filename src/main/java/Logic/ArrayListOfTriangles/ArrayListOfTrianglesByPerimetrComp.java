package Logic.ArrayListOfTriangles;

import Logic.Triangle.Triangle;

import java.util.Comparator;

public class ArrayListOfTrianglesByPerimetrComp  implements Comparator<Triangle> {

    public int compare(Triangle firstElement, Triangle secondElement) {
            if (firstElement.getPerimetr() > secondElement.getPerimetr()) {
                return 1;
            } else {
                return -1;
            }

    }
}
