package WS_Patterns.Pages.FBClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsTestFB {
    @FindBy(id = "rates")
    WebElement CompareText;

    public ReportsTestFB(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String GetTextReport() {
        return CompareText.getText();
    }
}
