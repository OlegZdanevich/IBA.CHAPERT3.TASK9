package com.iba.task9.observer;


import com.iba.task9.entity.triangle.Triangle;


public interface Observer
{
    void update (Triangle oldTriangle,Triangle newTriangle);
}
