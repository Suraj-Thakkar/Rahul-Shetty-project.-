package com.packb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayMetScr extends AbstractClass{

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement SelCon;
    @FindBy(xpath = "//span[text()=' India']")
    WebElement Opt1;
    @FindBy(css = "a.btnn")
    WebElement  PlcOrd;
    By SelectCountry=By.xpath("//input[@placeholder='Select Country']");
    By Option1=By.xpath("//span[text()=' India']");
    By PlcOrdBtn=By.cssSelector("a.btnn");
    public PayMetScr(WebDriver driver){
        super(driver);
    }
    public FinalScr Particle(){
        waitForSpinnerToDisappear(spinner);
        WaitForElementAppear(SelectCountry);
        WaitForEleClick(SelCon);
        SelCon.sendKeys("india");
        WaitForElementAppear(Option1);
        Opt1.click();
        WaitForElementAppear(PlcOrdBtn);
        PlcOrd.click();
        FinalScr finalScr=new FinalScr(driver);
        return finalScr;


    }
}
