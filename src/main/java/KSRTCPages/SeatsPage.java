package KSRTCPages;

import AmazonPages.SearchResultsPageAmazon;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.Select;

public class SeatsPage {

    WebDriver _driver;
    WebDriverWait wait;

    @FindBy(how = How.CSS, using = "ul[class=bus-select-seat] li[onclick] ")
    private List <WebElement> _emptySeats;

    @FindBy(how = How.XPATH, using = "//a[text()='Dropping Point']")
    private WebElement _DroppingPoint;

    @FindBy(how = How.XPATH, using = "//li[contains(@class,'p-2 Forward-droping')]")
    private List <WebElement> _AllDroppingPoints;

    @FindBy(how = How.XPATH, using = "//a[text()='Customer Details']")
    private WebElement _CustomerDetails;

    @FindBy(how = How.ID, using = "mobileNo")
    private WebElement _MobileNo;

    @FindBy(how = How.ID, using = "email")
    private WebElement _email;

    @FindBy(how = How.ID, using = "passengerNameForward0")
    private WebElement _PassengerName;

    @FindBy(how = How.ID, using = "passengerAgeForward0")
    private WebElement _PassengerAge;

    @FindBy(how = How.XPATH, using = "//button[contains(@method,'card')]")
    private WebElement _Card;

    @FindBy(how = How.ID, using = "card_number")
    private WebElement _CardNumber;

    @FindBy(how = How.ID, using = "card_expiry")
    private WebElement _CardExpiary;

    @FindBy(how = How.ID, using = "card_name")
    private WebElement _CardName;

    @FindBy(how = How.ID, using = "card_cvv")
    private WebElement _CardCVV;





    public SeatsPage(WebDriver driver)
    {
        _driver = driver;
        PageFactory.initElements(_driver, this);
        wait = new WebDriverWait(_driver, Duration.ofSeconds(20));
    }


    //zero based element
    public void ClickSeatByIndex(int index)
    {
        WebElement element = _driver.findElement(By.cssSelector("div[class='select-service'] [id = SrvcSelectBtnForward"+index+"]"));
        element.click();
    }

    public void SelectFirstEmptySeat()
    {
        for (WebElement seat: _emptySeats) {
            seat.click();
            break;
        }
    }

    public void SelectFirstDropPoint()
    {
        _DroppingPoint.click();
        for (WebElement FirstDropPoint: _AllDroppingPoints) {
            FirstDropPoint.click();
            break;
        }
    }

    public SeatsPage SendMobile(String searchString)
    {
        _MobileNo.sendKeys(searchString);
        return new SeatsPage(_driver);
    }

    public SeatsPage SendMail(String searchString)
    {
        _email.sendKeys(searchString);
        return new SeatsPage(_driver);
    }

    public SeatsPage SendName(String searchString)
    {
        _PassengerName.sendKeys(searchString);
        return new SeatsPage(_driver);
    }

    public SeatsPage SendAge(String searchString)
    {
        _PassengerAge.sendKeys(searchString);
        return new SeatsPage(_driver);

    }

    public SeatsPage SelectGender(String searchString) {
        WebElement GenderDropDown = _driver.findElement(By.id("genderCodeIdForward0"));
        Select genderdropdown = new Select(GenderDropDown);
        genderdropdown.selectByVisibleText(searchString);
        return new SeatsPage(_driver);
    }

    public SeatsPage SelectConcession(String searchString) {
        WebElement ConcessionDropDown = _driver.findElement(By.id("concessionIdsForward0"));
        Select concessiondropdown = new Select(ConcessionDropDown);
        concessiondropdown.selectByVisibleText(searchString);
        return new SeatsPage(_driver);
    }

    public void ClickMakePayment()  {
        WebElement Payment = _driver.findElement(By.id("PgBtn"));
        Payment.click();
    }

    public void PayByCard()  {
        _driver.switchTo().frame( _driver.findElement( By.className( "razorpay-checkout-frame" ) ) );
        WebElement card = _Card;
        card.click();

    }

    public SeatsPage SendCardNumber(String searchString)
    {
        _CardNumber.sendKeys(searchString);
        return new SeatsPage(_driver);

    }

    public SeatsPage SendCardExpiary(String searchString)
    {
        _CardExpiary.sendKeys(searchString);
        return new SeatsPage(_driver);

    }

    public SeatsPage SendCardName(String searchString)
    {
        _CardName.sendKeys(searchString);
        return new SeatsPage(_driver);

    }

    public SeatsPage SendCardCVV(String searchString)
    {
        _CardCVV.sendKeys(searchString);
        return new SeatsPage(_driver);

    }

}
