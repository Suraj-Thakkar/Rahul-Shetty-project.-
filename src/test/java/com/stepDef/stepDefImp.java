package com.stepDef;
import com.packb.*;
import com.packb.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class stepDefImp extends BaseTest {
    public LogScr logScr;
    public ProdListScr prodListScr;
    public CartScreen cartScreen;
    public PayMetScr payMetScr;
    public FinalScr finalScr;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws Exception {
        logScr=launchApp();
    }
    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username_and_password(String userName, String password){
        prodListScr=logScr.logScreen(userName, password);
    }
    @When("^I add the product (.+) to cart$")
    public void I_add_the_product_to_cart(String productName){
        cartScreen=prodListScr.ProductList(productName);
    }
   // And checkout <productName> and submit the order
    @And("^checkout (.+) and submit the order$")
    public void Checout_Submit_Order(String productName){
        payMetScr=cartScreen.Play();
        finalScr=payMetScr.Particle();
    }
   // Then "THANKYOU FOR THE ORDER." message is displayed in the confirmation page
    @Then("{string} message is displayed in the confirmation page")
    public void Confirmation_Message_Displayed(String expectedMessage){
        String confirmMess=finalScr.TestScr();
        Assert.assertTrue(confirmMess.equalsIgnoreCase(expectedMessage));
    }

    @Then("{string} message is displayed")
    public void Message_Is_Displayed(String expectedMessage){
        Assert.assertTrue(expectedMessage.equalsIgnoreCase("Incorrect email or password."));
    }

}
