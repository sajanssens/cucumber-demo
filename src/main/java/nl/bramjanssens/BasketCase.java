package nl.bramjanssens;

public class BasketCase {

    private static final ShoppingBasket<Product> products = new ShoppingBasket<>();

    public void add(String name) {
        products.add(new Product(name));
    }

    public void delete(String name) {
        products.remove(new Product(name));
    }

    public int size() {
        return products.size();
    }

}
