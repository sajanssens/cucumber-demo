package nl.bramjanssens.tabledemos;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Stepdefs {
    private List<String> animals;
    private List<List<String>> animalsCount;
    private List<Map<String, String>> animalMap;
    private List<AnimalCount> animalCounts;

    private long actual;

    public record AnimalCount(String animal, int count) { }

    @DataTableType
    public AnimalCount toAnimalCount(Map<String, String> row) {
        return new AnimalCount(
                row.get("animal"),
                parseInt(row.get("count"))
        );
    }

    @Given("the following animals:")
    public void theFollowingAnimals(List<String> animals) {
        this.animals = animals;
    }

    @Given("the following animal count:")
    public void theFollowingNumberOfAnimals(List<List<String>> animalsCount) {
        this.animalsCount = animalsCount;
    }

    @Given("the following table of animals:")
    public void theFollowingTableOfAnimals(List<Map<String, String>> animalMap) {
        this.animalMap = animalMap;
    }

    @Given("the following animal counts:")
    public void theFollowingAnimalCounts(List<AnimalCount> animalCounts) {
        this.animalCounts = animalCounts;
    }

    @When("I count the number of different species")
    public void iCountTheNumberOfDifferentSpecies() {
        this.actual = this.animals.stream().distinct().count();
    }

    @When("I count the number of animals")
    public void iCountTheNumberOfAnimals() {
        this.actual = this.animalsCount.stream()
                .mapToInt(row -> parseInt(row.get(1)))
                .sum();
    }

    @When("I count the number of animals in this table")
    public void iCountTheNumberOfAnimalsInThisTable() {
        this.actual = this.animalMap.stream()
                .mapToInt(row -> parseInt(row.get("count")))
                .sum();
    }

    @When("I sum the numbers")
    public void iSumTheNumbers() {
        this.actual = this.animalCounts.stream().mapToInt(AnimalCount::count).sum();
    }

    @Then("It should be {int}")
    public void itShouldBe(int count) {
        assertEquals(count, this.actual);
    }

    public record Product(String name) { }

    @DataTableType
    public Product from(String from) {
        return new Product(from);
    }

    public record OrderLine(String name, int qty) { }

    @Given("I have an empty basket")
    public void iHaveAnEmptyBasket() {

    }

    @When("I add these single column rows:") // single column row as string
    public void iAddTheseRows(List<String> products) {
        products.forEach(System.out::println);
    }

    @When("I add these single column products:") // single column row as Product wanted, @DataTableType String->Product needed
    public void iAddTheseProducts(List<Product> products) {
        products.forEach(System.out::println);
    }

    @When("I add these product rows with header:") // single column row as map of strings (with name key from header)
    public void iAddTheseProductRowsWithHeader(List<Map<String, String>> products) {
        products.forEach(System.out::println);
    }

    @When("I add these order line rows with header:") // multi-column row as map of strings (with name and qty keys from header)
    public void iAddTheseRowsWithHeader(List<Map<String, String>> orderLines) {
        orderLines.forEach(System.out::println);
    }

    @When("I add these order lines with header:") // multi-column row as OrderLine wanted, so @DataTableType Map<String, String> -> OrderLine needed
    public void iAddTheseOrderLines(List<OrderLine> orderLines) {
        orderLines.forEach(System.out::println);
    }

    @DataTableType
    public OrderLine toOrderLine(Map<String, String> row) {
        return new OrderLine(row.get("product"), parseInt(row.get("qty")));
    }

    @Then("It should contain {int} products")
    public void itShouldContainProducts(int total) {
    }
}
