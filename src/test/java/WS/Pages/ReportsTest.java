package WS.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import WS.HomePage;

public class ReportsTest {
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
    public void ValidCHargeSuuccess(){
        String CompareText= calculatorpage.GetTextReport();
        Assertions.assertEquals(" Los Angeles Homebuyers Can   Refinance at  Today's Mortgage Rates   Right Now!",CompareText,"The message is not the same" );
    }




    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
