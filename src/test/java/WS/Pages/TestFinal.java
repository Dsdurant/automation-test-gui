package WS.Pages;

import WS.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFinal {
    WebDriver driver;
    HomePage calculatorpage;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        calculatorpage= new HomePage(driver);
    }
    @Test
    public void ValidDisclaimer(){
        calculatorpage.InteractButtonShare();
        String DisclaimerText= calculatorpage.GetTextDisclaimer();
        Assertions.assertEquals("https://www.mortgagecalculator.org/?q=Q6Yg-4KX",DisclaimerText,
                "The message is not the same" );
    }



    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

