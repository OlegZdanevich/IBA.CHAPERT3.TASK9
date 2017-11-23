package com.oleg.observer;


import com.oleg.logic.triangle.triangle.Triangle;


public interface Observer
{
    void update (Triangle oldTriangle,Triangle newTriangle);
}
