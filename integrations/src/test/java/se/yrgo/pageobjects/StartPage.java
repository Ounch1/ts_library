package se.yrgo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By findBookButton = By.xpath("//a[contains(text(), 'Find a book')]");

    public StartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public SearchPage goToSearchPage() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(findBookButton));
        button.click();
        return new SearchPage(driver);
    }
}
