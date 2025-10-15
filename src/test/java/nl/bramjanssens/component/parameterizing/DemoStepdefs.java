package nl.bramjanssens.component.parameterizing;

import io.cucumber.java.en.When;

public class DemoStepdefs {

    @When("^I add a (.*) to my regular basket$")
    public void addReg(String product) {

    }

    @When("I add a {string} to my cucumber basket")
    public void addReg2(String product) {

    }

    @When("I add {int} {word}(s) to my cucumber basket")
    public void addCuc(int qty, String product) {
        System.out.println(qty);
        System.out.println(product);
    }
}
