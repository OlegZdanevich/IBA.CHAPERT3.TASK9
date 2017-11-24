package com.iba.task9.keeper.types;

import java.util.HashSet;
import java.util.Iterator;

public class TypesKeeper<V> implements Iterable<V>{
    HashSet<V> types = null;


    public TypesKeeper() {
        types = new HashSet<>();
    }

    public void addElement(V element) {
        types.add(element);
    }

    public void deleteElement(V element) {
        types.remove(element);
    }

    public HashSet<V> getTypes() {
       return this.types;
    }

    public Iterator<V> iterator() {
        return types.iterator();
    }


}
