package WS.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import WS.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestChart {
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
    public void validatechart(){
        String valorAntes = calculatorpage.getAttributeToggle();
        calculatorpage.clickRedirect();
        String valorDespues = calculatorpage.getAttributeToggle();
        Assertions.assertNotEquals(valorAntes,valorDespues,"El atributo Style no cambió luego del click");
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

