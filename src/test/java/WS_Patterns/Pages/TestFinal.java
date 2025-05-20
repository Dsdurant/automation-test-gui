package WS_Patterns.Pages;

import WS_Patterns.HomePage;
import WS_Patterns.Pages.FBClasses.TestFinalFB;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestFinal {
    WebDriver driver;
    TestFinalFB AttributeMedium;

    @BeforeEach
    public void setUp(){
        driver = DriverFactoryClass.getDriver(BrowserType.EDGE);
        driver.get("https://www.mortgagecalculator.org/");
        AttributeMedium = new TestFinalFB(driver);
    }
    @Test
    public void ValidDisclaimer(){
        AttributeMedium.InteractButtonShare();
        String DisclaimerText= AttributeMedium.GetTextDisclaimer();
        Assertions.assertEquals("https://www.mortgagecalculator.org/?q=Q6Yg-4KX",DisclaimerText,
                "The message is not the same" );
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

