package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage {

    private final WebDriver driver;

    private final By successMessage = By.cssSelector("div.post-header>h1");
    private final By logoutButton = By.xpath("//a[text()='Log out']");

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
