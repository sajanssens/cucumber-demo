package nl.bramjanssens;

import java.util.LinkedList;
import java.util.List;

public class ShoppingBasket<T> {

    private final List<T> contents = new LinkedList<>();

    public void add(T item) {
        this.contents.add(item);
    }

    public void remove(T item) {
        this.contents.remove(item);
    }

    public int size() {
        return contents.size();
    }
}
