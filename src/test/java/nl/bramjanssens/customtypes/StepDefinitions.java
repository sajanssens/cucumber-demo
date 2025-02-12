package nl.bramjanssens.customtypes;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;

public class StepDefinitions {

    @ParameterType(value = "red|green|blue", name = "rgb")
    public Pixel toPixel(String color) {
        return new Pixel(color);
    }

    @Given("I have a {rgb} pixel")
    public void iHaveAPixel(Pixel p) {
        // step implementation
    }

    @ParameterType(".*")
    public Book b(String title) {
        return new Book(title);
    }

    @Given("{b} is my favorite book")
    public void bookIsMyFavoriteBook(Book book) {
        // step implementation
    }

    @Given("I have {int} \\{what?!} cucumber(s) in my belly \\(amazing!)")
    public void iHaveWhatCucumbersInMyBelly(int arg0) {
    }
}
