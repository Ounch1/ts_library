package se.yrgo.integrations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import se.yrgo.Helper;
import se.yrgo.pageobjects.SearchPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchByNameStepDefinition {

    WebDriver driver = GeneralStepDefinitions.getDriver();
    SearchPage searchPage;
    @Given("user is on the search page")
    public void user_is_on_the_search_page() {
        Helper.goToPage(driver,"http://frontend/search");
        searchPage = new SearchPage(driver);

        assertTrue(searchPage.canSeeForm());
    }

    @When("user enters {string} into search field")
    public void user_enters_into_search_field(String bookName) {
        searchPage.inputName(bookName);
    }

    @When("clicks SEARCH button")
    public void clicks_SEARCH_button() {
        searchPage.pressSearch();
    }

    @Then("book titled {string} listed")
    public void book_titled_listed(String expectedBookName) {
        List<String> bookNames = searchPage.getDisplayedBookNames();

        for (String bookName : bookNames){
            assertEquals(expectedBookName, bookName);
        }


    }
}