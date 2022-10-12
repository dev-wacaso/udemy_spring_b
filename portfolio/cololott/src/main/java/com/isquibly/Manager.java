package com.isquibly;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final List<Gime> gimesCollection = new ArrayList<Gime>();

    public Manager() {
        gimesCollection.add(new Gime("", "pb", 5, 1, 69, 1, 26));
        gimesCollection.add(new Gime("", "mm", 5, 1,70, 1,25));
        gimesCollection.add(new Gime("", "ll", 5, 1,48,1,18));
        gimesCollection.add(new Gime("", "cl", 6, 1,40,0,0));
        gimesCollection.add(new Gime("", "c5", 5, 1,32, 0,0));
    }
}
