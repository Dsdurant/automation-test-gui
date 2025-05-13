package WS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
//on attribute change, undisabled,
    WebDriver driver;

    @FindBy(id="homeval")
    WebElement homevalueInput;

    @FindBy(id="downpayment")
    WebElement DownPayment;

    @FindBy(name = "cal")
    WebElement calculateButton;

    @FindBy(xpath = "//div[@class='left-cell']/h3")
    WebElement TotalMonthlyPayment;
// ///////////////////////////////////////////////////////////////////////
    @FindBy(id="toggle_pie")
    WebElement Redirectchart;

    @FindBy(id="toggle")
    WebElement PieChartExpanded;

// ///////////////////////////////////////////////////////////////////////

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
// ///////////////////////////////////////////////////////////////////////
    @FindBy (id="rates")
    WebElement CompareText;
// ///////////////////////////////////////////////////////////////////////
    @FindBy(id ="share_url_input")
    WebElement Disclaimer;
    @FindBy(id = "share_button")
    WebElement ShareButton;
// ///////////////////////////////////////////////////////////////////////
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // ----------------------------------------------------------------------------
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
    // ----------------------------------------------------------------------------
    public void clickRedirect(){
        Redirectchart.click();
    }
    public String getAttributeToggle(){
        return PieChartExpanded.getAttribute("style");
    }
    // ----------------------------------------------------------------------------
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
// ----------------------------------------------------------------------------
    public String GetTextReport() {
    return CompareText.getText();
    }
// ----------------------------------------------------------------------------
    public String GetTextDisclaimer() {
    return Disclaimer.getAttribute("value");
    }
    public void InteractButtonShare(){
        ShareButton.click();
    }
}

