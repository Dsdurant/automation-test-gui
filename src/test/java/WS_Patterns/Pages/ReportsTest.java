package WS_Patterns.Pages;

import WS_Patterns.HomePage;
import WS_Patterns.Pages.FBClasses.ReportsTestFB;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import WS_Patterns.Pages.BrowserType;
import WS_Patterns.Pages.DriverFactoryClass;
public class ReportsTest {
    WebDriver driver;
    ReportsTestFB ReportMedium;

    @BeforeEach
    public void setUp(){
        driver = DriverFactoryClass.getDriver(BrowserType.EDGE);
        driver.get("https://www.mortgagecalculator.org/");
        ReportMedium= new ReportsTestFB(driver);
    }
    @Test
    public void ValidCHargeSuuccess(){
        String CompareText= ReportMedium.GetTextReport();
        Assertions.assertEquals(" Los Angeles Homebuyers Can   Refinance at  Today's Mortgage Rates   Right Now!",CompareText,"The message is not the same" );
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
