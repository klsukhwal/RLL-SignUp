package StepDef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;
import Pages.BaseClass;
import Pages.SignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpDef {
    private static final Logger logger = LogManager.getLogger(SignUpDef.class);

    SoftAssert soft = new SoftAssert();
    SignUp sup;

    @Given("User is on SignUp page")
    public void user_is_on_sign_up_page() {
        logger.info("User is on SignUp page");
        sup = new SignUp(BaseClass.getDriver());
        sup.clickonSignUpHere();
    }

    @When("Check next button without any data")
    public void check_next_button_without_any_data() {
        sup.clickonNext();
        soft.assertTrue(sup.validate_Title_DrpDwn(), "Assert failed- Reading empty fields");
        logger.info("Checking next button without any data");
    }

    @Then("Check next button with already registered data")
    public void check_next_button_with_already_registered_data() {
    	sup.enterSignUpDetailsPage("Mr.", "Kishan", "Sukhwal", "01/30/2000", "123-45-1234", "kls123@gmail.com", "Kls12345", "Kls12345");
		sup.clickonNext();
		soft.assertTrue(sup.validate_Already_Registered_data(), "Assert failed- No error displayed");
        logger.info("Checking next button with already registered data");
    }

    @Then("Check next button with valid data")
    public void check_next_button_with_valid_data() {
        sup.enterSignUpDetailsPage("Mr.", "Kishan", "Sukhwal", "01/30/2000", "255-28-0059", "kls123kljldf1wsd4dqdd@gmail.com", "Kls12345", "Kls12345");
        sup.clickonNext();
        logger.info("Checking next button with valid data");
    }

    @Then("Check Register button without any data")
    public void check_register_button_without_any_data() {
        sup.clickonRegisterBtn();
        soft.assertTrue(sup.validate_address(), "Assert failed- Reading empty fields");
        logger.info("Checking Register button without any data");
    }

    @Then("Check Register button with valid data")
    public void check_register_button_with_valid_data() throws InterruptedException {
        sup.enterSignUpDetailsPage1("Kota", "Kota", "Kota", "323307", "India", "9587206196", "9587206196", "9587206196");
        sup.clickonRegisterBtn();
        logger.info("Checking Register button with valid data");
    }
}























