package com.endava.training;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testUserAccess() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        System.out.println("Step 1. Enter Usernema");
        WebElement userField = driver.findElement(By.xpath("//div[label[@for='username']]/input"));
        userField.sendKeys("user");

        System.out.println("Step 2. Enter Password");
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("pss");

        System.out.println("Step 3. Click Submit");
        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        System.out.println("Step 4. Fetch Error Message");
        WebElement errorMessage = driver.findElement(By.cssSelector("div[id='error']"));
        String errorText = errorMessage.getText();

        System.out.println("Step 5. Validate Error Message");
        //assertTrue(errorText.contains("Invalid"), "Wrong Error Message");
        assertEquals("Your username is invalid", errorText, "Error on Message Text");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
