package com.iba.task9.entity.point;

public class Point
{
    private int x;
    private int y;

    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public Point(Point point)
    {
        this.x=point.x;
        this.y=point.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (getX() != point.getX()) return false;
        return getY() == point.getY();
    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }

    @Override
    public String toString()
    {
        return "{x: "+x+" ,y:"+y+" }";
    }
}
