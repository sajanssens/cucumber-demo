package nl.bramjanssens.apiautomation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;

public class QueryStarWarsApiSteps {

    private Response response;

    @Given("I go to SWAPI")
    public void iGoToSWAPI() {
        RestAssured.baseURI = "https://swapi.dev/api/";
    }

    @When("I search for person {int}")
    public void iSearchForPerson(int id) {
        response = get("/people/" + id);
    }

    @Then("I get a successful response")
    public void theStatusCodeIs() {
        response.then().statusCode(200);
    }

    @And("the person name is {string}")
    public void thePersonNameIs(String name) {
        response.then().body("name", containsString(name)); ;
    }
}
