package com.packb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartScreen extends AbstractClass{

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement CheckoutBtn;
    By ChckOut=By.xpath("//button[text()='Checkout']");

    public CartScreen(WebDriver driver){
        super(driver);
    }
    public PayMetScr Play(){
        WaitForElementAppear(ChckOut);
        CheckoutBtn.click();
        PayMetScr payMetScr=new PayMetScr(driver);
        return payMetScr;

    }
}
