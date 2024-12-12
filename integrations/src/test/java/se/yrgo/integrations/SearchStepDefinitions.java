package se.yrgo.integrations;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SearchStepDefinitions {
    WebDriver driver = GeneralStepDefinitions.getDriver();

    @When("the user navigates to the book search.")
    public void the_user_navigates_to_the_book_search() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://frontend");

        WebElement button = driver.findElement(By.xpath("//a[contains(text(), 'Find a book')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

        assertTrue(driver.getCurrentUrl().contains("search"));
    }
    @Then("they can see the search form.")
    public void they_can_see_the_search_form() {
        assertTrue(driver.findElement(By.className("max-w-md w-full bg-base-300 rounded p-6 space-y-4")).isDisplayed());
    }
}