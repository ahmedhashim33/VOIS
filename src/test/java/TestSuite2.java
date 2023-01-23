import AmazonPages.HomePageAmazon;
import AmazonPages.SearchResultsPageAmazon;
import KSRTCPages.LandingPage;
import KSRTCPages.SeatsPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
public class TestSuite2 extends BaseTest {

    @Test
    public void TestCase3() throws InterruptedException {
        driver.navigate().to("https://ksrtc.in/oprs-web/guest/home.do?h=1");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.SelectRoutesByCities("Chikkamagaluru", "Bengaluru");
        landingPage.SelectCurrentDate();
        SeatsPage seats = landingPage.SearchFOrBus();
        seats.ClickSeatByIndex(0);
        seats.SelectFirstEmptySeat();
        seats.SelectFirstDropPoint();
        SeatsPage mobile = new SeatsPage(driver);
        mobile.SendMobile("6789125987");
        SeatsPage email = new SeatsPage(driver);
        email.SendMail("Test@test.com");
        SeatsPage PassangerName = new SeatsPage(driver);
        PassangerName.SendName("Ahmed Hashem");
        SeatsPage PassangerAge = new SeatsPage(driver);
        PassangerAge.SendAge("28");
        SeatsPage PassangerGender = new SeatsPage(driver);
        PassangerGender.SelectGender("MALE");
        SeatsPage PassangerConcession= new SeatsPage(driver);
        PassangerConcession.SelectConcession("GENERAL PUBLIC");
        seats.ClickMakePayment();
        seats.PayByCard();
        SeatsPage CNumber = new SeatsPage(driver);
        CNumber.SendCardNumber("4463735687654567");
        SeatsPage CExpiary = new SeatsPage(driver);
        CExpiary.SendCardExpiary("0425");
        SeatsPage CName = new SeatsPage(driver);
        CName.SendCardName("Ahmed Hashem");
        SeatsPage CCVV = new SeatsPage(driver);
        CCVV.SendCardCVV("076");
        driver.switchTo().defaultContent();

    }


}
