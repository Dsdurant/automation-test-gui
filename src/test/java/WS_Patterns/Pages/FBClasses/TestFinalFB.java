package WS_Patterns.Pages.FBClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestFinalFB {
    @FindBy(id ="share_url_input")
    WebElement Disclaimer;
    @FindBy(id = "share_button")
    WebElement ShareButton;

    public TestFinalFB(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public String GetTextDisclaimer() {
        return Disclaimer.getAttribute("value");
    }
    public void InteractButtonShare(){
        ShareButton.click();
    }
}
