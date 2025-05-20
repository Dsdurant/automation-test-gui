package WS_Patterns.Pages.FBClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculationSection {

    @FindBy(id="homeval")
    WebElement homevalueInput;

    @FindBy(id="downpayment")
    WebElement DownPayment;

    @FindBy(name = "cal")
    WebElement calculateButton;

    @FindBy(xpath = "//div[@class='left-cell']/h3")
    WebElement TotalMonthlyPayment;

    public CalculationSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void EnterHomeValue(String value) {
        homevalueInput.clear();
        homevalueInput.sendKeys(value);
    }

    public void EnterDownPayment(String value) {
        DownPayment.clear();
        DownPayment.sendKeys(value);
    }

    public void clickCalculate(){
        calculateButton.click();
    }
    public String getTotalMonthlyPaymentText() {
        return TotalMonthlyPayment.getText();
    }

}
