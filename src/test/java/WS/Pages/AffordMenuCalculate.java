package WS.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import WS.HomePage;


public class AffordMenuCalculate {
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
    public void GoToAffoordabilityMenu(){
        calculatorpage.viewAffordMenu();
        calculatorpage.ViewAPRMenu();
        calculatorpage.SetHomeValue("4500000");
        calculatorpage.SetPayDown("2000");
        calculatorpage.SetinterestRate("17");
        calculatorpage.SetLengthValue("200");
        calculatorpage.SetPointsValue("12");
        calculatorpage.SetOriginationValue("22");
        calculatorpage.SetClosingValue("1200");
        calculatorpage.Calculate();
        String TextoMonthly=calculatorpage.GetTextMonthly();
        Assertions.assertEquals("Monthly Principal & Interests:",TextoMonthly,"Not the same");
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
