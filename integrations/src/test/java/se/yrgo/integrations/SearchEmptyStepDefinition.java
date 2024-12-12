package se.yrgo.integrations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.yrgo.Helper;
import se.yrgo.pageobjects.SearchPage;

import static org.junit.Assert.assertTrue;

public class SearchEmptyStepDefinition {
    WebDriver driver = GeneralStepDefinitions.getDriver();
    SearchPage searchPage;
    @Given("the user is on the search page.")
    public void the_user_is_on_the_search_page() {
        Helper.goToPage(driver,"http://frontend/search");
        searchPage = new SearchPage(driver);

        assertTrue(searchPage.canSeeForm());
    }

    @When("user presses SEARCH with empty input")
    public void user_presses_search_with_empty_input() {
        searchPage.inputName("");
        searchPage.pressSearch();
    }

    @Then("they can see failure message")
    public void they_can_see_failure_message() {
        WebElement errorMessage = searchPage.getFailureMessage();
        assertTrue(errorMessage.isDisplayed());
    }

}
