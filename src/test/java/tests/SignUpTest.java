package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.SignUp;
import Pages.TestBase;
import utilities.TestRetryAnalyzer;
import org.testng.annotations.Listeners;
import utilities.ITestListenerClass;

@Listeners(ITestListenerClass.class)
public class SignUpTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(SignUpTest.class);

    SoftAssert soft = new SoftAssert();
    SignUp sup;

    @BeforeMethod
    public void setup() {
        //getBrowser();
        sup = new SignUp(driver);
    }

    @Test(retryAnalyzer = TestRetryAnalyzer.class)
    public void testSignUp() throws InterruptedException {
        logger.info("Starting the testSignUp method");

        sup.clickonSignUpHere();

        // Validating NextButton without providing any data
        sup.clickonNext();
        soft.assertFalse(sup.validate_Title_DrpDwn(), "Assert failed- Reading empty fields");
        logger.info("Validating NextButton without providing any data");

        // Validating Next button with already registered data
        sup.enterSignUpDetailsPage("Mr.", "Kishan", "Sukhwal", "01/30/2000", "123-45-1234", "kls123@gmail.com", "Kls12345", "Kls12345");
        sup.clickonNext();
        soft.assertFalse(sup.validate_Already_Registered_data(), "Assert failed- No error displayed");
        logger.info("Validating Next button with already registered data");

        sup.enterSignUpDetailsPage("Mr.", "Kishan", "Sukhwal", "01/30/2000", "125-28-0059", "kls123kljlf1wsd4dqdd@gmail.com", "Kls12345", "Kls12345");
        sup.clickonNext();

        sup.clickonRegisterBtn();
        soft.assertFalse(sup.validate_address(), "Assert failed- Reading empty fields");
        logger.info("Validating Register button without any data");

        sup.enterSignUpDetailsPage1("Kota", "Kota", "Kota", "323307", "India", "9587206196", "9587206196", "9587206196");
        sup.clickonRegisterBtn();

        soft.assertAll();
        logger.info("Ending the testSignUp method");
    }
}
