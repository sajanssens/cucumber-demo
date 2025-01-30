package nl.bramjanssens;

import io.cucumber.java.en.When;

public class DemoStepdefs {

    @When("^I add a (.*) to my regular basket$")
    public void addReg(String product) {
    }

    @When("I add a {string} to my cucumber basket")
    public void addCuc(String arg0) {

    }
}
