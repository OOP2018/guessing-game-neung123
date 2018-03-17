package app;

import java.util.Observable;

/**
 * A simple counter.
 */

public class Counter extends Observable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void add(int howmuch) {
        count += howmuch;

        setChanged();
        notifyObservers();
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
