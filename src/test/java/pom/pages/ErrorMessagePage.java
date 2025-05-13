package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorMessagePage {

    private final WebDriver driver;

    private final By errorMessage = By.cssSelector("div[id='error']");

    public ErrorMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
