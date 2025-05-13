package pom;

import pom.pages.ErrorMessagePage;
import pom.pages.LoginPage;
import pom.pages.SuccessPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPOMTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ErrorMessagePage errorPage;
    private SuccessPage successPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        errorPage = new ErrorMessagePage(driver);
        successPage = new SuccessPage(driver);
    }

    @Test
    public void testUserAccess() {
        loginPage.open();
        System.out.println("Step 1. Enter Usernema");
        loginPage.enterUsername("user");

        System.out.println("Step 2. Enter Password");
        loginPage.enterPassword("pss");

        System.out.println("Step 3. Click Submit");
        loginPage.clickSubmit();

        System.out.println("Step 4. Fetch Error Message");
        String error = errorPage.getErrorMessage();

        System.out.println("Step 5. Validate Error Message");
        assertEquals("Your username is invalid", error, "Error on Message Text");
    }

    @Test
    public void testUserAccessOK() {
        loginPage.open();
        System.out.println("Step 1. Enter Usernema");
        loginPage.enterUsername("student");

        System.out.println("Step 2. Enter Password");
        loginPage.enterPassword("Password123");

        System.out.println("Step 3. Click Submit");
        loginPage.clickSubmit();

        System.out.println("Step 4. Fetch Success Message");
        String error = successPage.getSuccessMessage();

        System.out.println("Step 5. Validate Error Message");
        assertEquals("Logged In Successfully", error, "Login OK");

        System.out.println("Step 6. Logout");
        successPage.clickLogoutButton();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
