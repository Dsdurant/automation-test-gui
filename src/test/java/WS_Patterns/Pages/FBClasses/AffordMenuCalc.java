package WS_Patterns.Pages.FBClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AffordMenuCalc {

    @FindBy(xpath = "//a[contains(.,'Affordability')]")
    WebElement AffordMenu;
    @FindBy(xpath = "//div[contains(.,'Mortgage Tools')]/ul/li/a[contains(.,'Real APR')]")
    WebElement RealAPRMenu;
    @FindBy(xpath = "//input[@name='HomeValue']")
    WebElement HomeValue;
    @FindBy(xpath = "//input[@name='DownPayment']")
    WebElement DownPymentperc;
    @FindBy(xpath = "//input[@name='Interest']")
    WebElement InterestRate;
    @FindBy(xpath = "//input[@name='Length']")
    WebElement LengthValue;
    @FindBy(xpath = "//input[@name='Points']")
    WebElement PointsValue;
    @FindBy(xpath = "//input[@name='Origination']")
    WebElement OriginationValue;
    @FindBy(xpath = "//input[@name='Closing']")
    WebElement ClosingValue;
    @FindBy(name ="calculate")
    WebElement CalculateBtn;
    @FindBy(xpath = "//td[contains(.,'Monthly Principal &')]")
    WebElement VerifyText;

    public AffordMenuCalc(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void viewAffordMenu(){
        AffordMenu.click();
    }
    public void ViewAPRMenu(){
        RealAPRMenu.click();
    }
    public void SetHomeValue(String value){
        HomeValue.clear();
        HomeValue.sendKeys(value);
    }
    public void SetPayDown(String value){
        DownPymentperc.clear();
        DownPymentperc.sendKeys(value);
    }
    public void SetinterestRate(String value){
        InterestRate.clear();
        InterestRate.sendKeys(value);
    }
    public void SetPointsValue(String value){
        PointsValue.clear();
        PointsValue.sendKeys(value);
    }
    public void SetOriginationValue(String value){
        OriginationValue.clear();
        OriginationValue.sendKeys(value);
    }
    public void SetClosingValue(String value){
        ClosingValue.clear();
        ClosingValue.sendKeys(value);
    }
    public void SetLengthValue(String value){
        LengthValue.clear();
        LengthValue.sendKeys(value);
    }
    public void Calculate(){
        CalculateBtn.click();
    }
    public String GetTextMonthly() {
        return VerifyText.getText();
    }

}
