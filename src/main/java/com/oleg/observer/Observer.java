package com.oleg.observer;


import com.oleg.entity.triangle.triangle.Triangle;


public interface Observer
{
    void update (Triangle oldTriangle,Triangle newTriangle);
}
