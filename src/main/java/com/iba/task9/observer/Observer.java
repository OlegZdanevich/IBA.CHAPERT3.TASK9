package com.iba.task9.observer;



public interface Observer<K>
{
    void update (K oldTriangle,K newTriangle);
}
