package app;

import java.util.Observable;

/**
 * A simple counter.
 *
 * @author Pornpavee Seri-umnuoy
 */

public class Counter extends Observable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    /**
     * Adding int value to count and update on display.
     * @param howmuch number that you want to add.
     */
    public void add(int howmuch) {
        count += howmuch;

        setChanged();
        notifyObservers();
    }

    /**
     * @return int value count
     */
    public int getCount() {
        return count;
    }

    /**
     * For setting count.
     * @param count number that you want to set to.
     */
    public void setCount(int count) {
        this.count = count;
    }
}
