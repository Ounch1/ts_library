package se.yrgo.integrations;

public class GeneralStepDefinitions {
    private static WebDriver driver;
    @Before
    public void setupWebDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),
                    options, false);
        } catch (MalformedURLException e) {
            fail(e);
        }
    }
    @After
    public void shutdownWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }
    @Given("the user is on the start page.")
    public void the_user_is_on_the_start_page() {
        driver.get("http://frontend");
        if (!"The Library".equals(driver.getTitle())) {
            throw new IllegalStateException("Not on the start page");
        }
    }
}