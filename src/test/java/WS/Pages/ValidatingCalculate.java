package WS.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import WS.HomePage;

public class ValidatingCalculate {
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
