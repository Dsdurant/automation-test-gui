package WS_Patterns.Pages;

import WS_Patterns.HomePage;
import WS_Patterns.Pages.FBClasses.ChartFB;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestChart {
    WebDriver driver;
    ChartFB ChartMedium;

    @BeforeEach
    public void setUp(){
        driver = DriverFactoryClass.getDriver(BrowserType.CHROME);
        driver.get("https://www.mortgagecalculator.org/");
        ChartMedium = new ChartFB(driver);
    }
    @Test
    public void validatechart(){
        String valorAntes = ChartMedium.getAttributeToggle();
        ChartMedium.clickRedirect();
        String valorDespues = ChartMedium.getAttributeToggle();
        Assertions.assertNotEquals(valorAntes,valorDespues,"El atributo Style no cambió luego del click");
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

