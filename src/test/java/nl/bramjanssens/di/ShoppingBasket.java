package nl.bramjanssens.di;

import java.util.LinkedList;
import java.util.List;

public class ShoppingBasket<T> {

    private List<T> contents = new LinkedList<>();

    public void addAll(List<T> products) {
        this.contents.addAll(products);
    }
}
