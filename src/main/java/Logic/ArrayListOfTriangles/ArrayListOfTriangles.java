package Logic.ArrayListOfTriangles;

import Logic.Point.Point;
import Logic.Triangle.Triangle;
import Exceptions.Exceptions;

import java.util.ArrayList;

public class ArrayListOfTriangles
{
    private ArrayList<Triangle>[] arrayListsOfTriangles=new ArrayList[5];

    public ArrayListOfTriangles(Triangle... triangles)
    {
        try {

            for(int i=0;i<arrayListsOfTriangles.length;i++)
            {
                arrayListsOfTriangles[i]=new ArrayList<>();
            }

            if (triangles.length == 0) throw new NullPointerException("This method should have triangles");

            for(int i=0;i<triangles.length;i++)
            {
                String type=triangles[i].getTypeOfTringle();

                switch (type)
                {
                    case "equilateral triangle":
                        arrayListsOfTriangles[0].add(triangles[i]);
                        break;

                    case "isosceles right triangle":
                        arrayListsOfTriangles[1].add(triangles[i]);
                        break;

                    case "isosceles triangle":
                        arrayListsOfTriangles[2].add(triangles[i]);
                        break;

                    case "arbitrary right triangle":
                        arrayListsOfTriangles[3].add(triangles[i]);
                        break;

                    case "arbitrary triangle":
                        arrayListsOfTriangles[4].add(triangles[i]);
                        break;
                }
            }
        }
        catch (NullPointerException exception) {

            Exceptions.noParametrException(exception);
            Exceptions.makeWarning(" Array will have only one triangle");

            arrayListsOfTriangles[0].add(new Triangle(new Point(0,0),new Point(0,0),new Point(0,0)));
        }


    }

    public void viewGroups()
    {
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

            trianglesOfThisGroup.sort(new ArrayListOfTrianglesByPerimetrComp());
            System.out.println("Max by perimetr: "+ trianglesOfThisGroup.get(trianglesOfThisGroup.size()-1));
            System.out.println("Min by perimetr: "+ trianglesOfThisGroup.get(0));

            trianglesOfThisGroup.sort(new ArrayListOfTrianglesBySquareComp());
            System.out.println("Max by square: "+ trianglesOfThisGroup.get(trianglesOfThisGroup.size()-1));
            System.out.println("Min by square: "+ trianglesOfThisGroup.get(0));
        }
    }


}
