package se.yrgo;

import org.openqa.selenium.WebDriver;

public class Helper {
    public static void goToPage(WebDriver driver, String url)
    {
        driver.get(url);
    }
}
