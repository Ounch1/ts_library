package se.yrgo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {
    private WebDriverWait wait;

    // Selectors and locators
    private final String formSelector = ".max-w-md.w-full.bg-base-300.rounded.p-6.space-y-4";
    private final String inputSelector = "form input[placeholder='Title']";
    private final String searchButtonSelector = "form input[value=\"Search\"]";
    public SearchPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void inputName(String name)
    {
        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputSelector)));
        inputField.sendKeys(name);
    }

    public void pressSearch()
    {
        WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(searchButtonSelector)));
        searchButton.click();
    }

    public boolean canSeeForm() {
        try {
            // Select the form that should pop up
            WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formSelector)));
            return form.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> getDisplayedBookNames() {
        // Use a refined CSS selector to fetch only book names
        List<WebElement> bookNameElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("tr > td.text-ellipsis.overflow-hidden.max-w-xs:first-of-type")
        ));

        // Extract text from the WebElements and return as a list of strings
        return bookNameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    // "No books found"
    public WebElement getFailureMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".errors.overflow-x-auto.my-4.flex.flex-col.items-center > div")));
    }

}
