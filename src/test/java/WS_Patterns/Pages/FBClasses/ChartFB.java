package WS_Patterns.Pages.FBClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChartFB {

    @FindBy(id="toggle_pie")
    WebElement Redirectchart;

    @FindBy(id="toggle")
    WebElement PieChartExpanded;

    public ChartFB(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickRedirect(){
        Redirectchart.click();
    }
    public String getAttributeToggle(){
        return PieChartExpanded.getAttribute("style");
    }
}
