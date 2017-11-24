package com.iba.task9.observer;

import com.iba.task9.entity.triangle.Triangle;

public interface Observable
{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(Triangle oldTrangle,Triangle newTriangle);
}
