package WS_Patterns.Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactoryClass {

    public static WebDriver getDriver(BrowserType Browser){
        WebDriver driver;

        switch(Browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver =new ChromeDriver();
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
                break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver =new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + Browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

}
