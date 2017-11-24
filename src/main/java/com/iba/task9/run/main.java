package com.iba.task9.run;


import com.iba.task9.entity.point.Point;
import com.iba.task9.entity.triangle.Triangle;
import com.iba.task9.keeper.TrianglesKeeper;
import com.iba.task9.loggin.exceptions.Exceptions;
import com.iba.task9.tools.keeper.KeeperView;

import java.io.*;
import java.util.ArrayList;

public class main {
    private static ArrayList<Triangle> arrayOfTriangles = new ArrayList<>();

    public static void main(String[] args) {
        try {
            File data = new File("data/data1.txt");
            getDataFromFile(data);

            TrianglesKeeper trianglesKeeper = TrianglesKeeper.getInstance();

            KeeperView.viewGroups(trianglesKeeper);
            arrayOfTriangles.get(0).setPoints(new Point(100, 100), new Point(0, 0), new Point(40, 150));


        } catch (FileNotFoundException exception) {
            Exceptions.fileNotFoundException(exception);
        } catch (IOException exception) {
            Exceptions.ReadFileException(exception);
        }

    }

    private static void addToKeeperTriangle(String line) {
        try {
            String[] byParts = line.split(",");

            if (byParts.length == 3) {
                String[] firstCoordiante = byParts[0].split(";");
                String[] secondCoordiante = byParts[1].split(";");
                String[] thirdCoordiante = byParts[2].split(";");

                if (firstCoordiante.length == 2 & secondCoordiante.length == 2 & thirdCoordiante.length == 2) {
                    int xFirstCoordiante = Integer.parseInt(firstCoordiante[0]);
                    int yFirstCoordiante = Integer.parseInt(firstCoordiante[1]);

                    int xSecondCoordiante = Integer.parseInt(secondCoordiante[0]);
                    int ySecondCoordiante = Integer.parseInt(secondCoordiante[1]);

                    int xThirdCoordiante = Integer.parseInt(thirdCoordiante[0]);
                    int yThirdCoordiante = Integer.parseInt(thirdCoordiante[1]);


                    Point firstPoint = new Point(xFirstCoordiante, yFirstCoordiante);
                    Point secondPoint = new Point(xSecondCoordiante, ySecondCoordiante);
                    Point thirdPoint = new Point(xThirdCoordiante, yThirdCoordiante);


                    Triangle triangleToAdd = new Triangle(firstPoint, secondPoint, thirdPoint);

                    arrayOfTriangles.add(triangleToAdd);

                    TrianglesKeeper keeper = TrianglesKeeper.getInstance();
                    keeper.addElement(triangleToAdd);

                } else throw new IllegalArgumentException(" Every coordinate should have only 2 parametrs");

            } else throw new IllegalArgumentException(" Every triangle should have only three points");
        } catch (NumberFormatException exception) {
            Exceptions.notNumberException(exception);
        } catch (IllegalArgumentException exception) {
            Exceptions.notCorrectNumbersException(exception);
        }


    }

    private static void getDataFromFile(File data) throws IOException {
        FileReader fr = new FileReader(data);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            addToKeeperTriangle(line);
            line = reader.readLine();
        }
    }
}

