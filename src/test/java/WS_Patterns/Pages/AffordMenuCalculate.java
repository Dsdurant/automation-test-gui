package WS_Patterns.Pages;

import WS_Patterns.HomePage;
import WS_Patterns.Pages.FBClasses.AffordMenuCalc;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import WS_Patterns.Pages.BrowserType;
import WS_Patterns.Pages.DriverFactoryClass;

public class AffordMenuCalculate {
    WebDriver driver;
    AffordMenuCalc CalculateAfford;

    @BeforeEach
    public void setUp(){
        driver = DriverFactoryClass.getDriver(BrowserType.EDGE);
        driver.get("https://www.mortgagecalculator.org/");
        CalculateAfford= new AffordMenuCalc(driver);
    }
    @Test
    public void GoToAffoordabilityMenu(){
        CalculateAfford.viewAffordMenu();
        CalculateAfford.ViewAPRMenu();
        CalculateAfford.SetHomeValue("4500000");
        CalculateAfford.SetPayDown("2000");
        CalculateAfford.SetinterestRate("17");
        CalculateAfford.SetLengthValue("200");
        CalculateAfford.SetPointsValue("12");
        CalculateAfford.SetOriginationValue("22");
        CalculateAfford.SetClosingValue("1200");
        CalculateAfford.Calculate();
        String TextoMonthly=CalculateAfford.GetTextMonthly();
        Assertions.assertEquals("Monthly Principal & Interests:",TextoMonthly,"Not the same");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
