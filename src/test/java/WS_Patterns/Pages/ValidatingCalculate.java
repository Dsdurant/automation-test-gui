package WS_Patterns.Pages;

import WS_Patterns.HomePage;
import WS_Patterns.Pages.FBClasses.CalculationSection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import WS_Patterns.Pages.BrowserType;
import WS_Patterns.Pages.DriverFactoryClass;

public class ValidatingCalculate {
    WebDriver driver;
    CalculationSection calculatorpage;

    @BeforeEach
    public void setUp(){
        driver = DriverFactoryClass.getDriver(BrowserType.CHROME);
        driver.get("https://www.mortgagecalculator.org/");
        calculatorpage= new CalculationSection(driver);
    }

    @Test
    public void testcalculation(){
        calculatorpage.EnterHomeValue("3000");
        calculatorpage.EnterDownPayment("2000");
        calculatorpage.clickCalculate();
        String actualResult = calculatorpage.getTotalMonthlyPaymentText();
        String expectedResult = "$381.31";
        Assertions.assertEquals(expectedResult, actualResult, "El resultado del cálculo no es el esperado.");

    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
