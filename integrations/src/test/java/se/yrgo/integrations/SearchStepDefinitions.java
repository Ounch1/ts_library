package se.yrgo.integrations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import se.yrgo.pageobjects.SearchPage;
import se.yrgo.pageobjects.StartPage;

import static org.junit.Assert.assertTrue;

public class SearchStepDefinitions {
    WebDriver driver = GeneralStepDefinitions.getDriver(); // It will go to start page, as defined in GeneralStepDefinition

    // Page objects
    StartPage startPage;
    SearchPage searchPage;

    @When("the user navigates to the book search.")
    public void the_user_navigates_to_the_book_search() {
        startPage = new StartPage(driver);
        searchPage = startPage.goToSearchPage();
        assertTrue(driver.getCurrentUrl().contains("search"));
    }
    @Then("they can see the search form.")
    public void they_can_see_the_search_form() {
        assertTrue(searchPage.canSeeForm());
    }
}