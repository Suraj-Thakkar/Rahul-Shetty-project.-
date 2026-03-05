package com.packb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FinalScr extends AbstractClass{

    @FindBy(tagName = "h1")
    WebElement HeaderTxt;
    By HeaderText=By.tagName("h1");
    public FinalScr(WebDriver driver){
        super(driver);
    }
    public String TestScr(){
        WaitForElementAppear(HeaderText);
        String Head1=HeaderTxt.getText().trim();
        return Head1;

    }
}
