package com.oleg.observer;

import com.oleg.entity.triangle.triangle.Triangle;

public interface Observable
{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(Triangle oldTrangle,Triangle newTriangle);
}
