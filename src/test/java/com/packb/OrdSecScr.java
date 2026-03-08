package com.packb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class OrdSecScr extends AbstractClass{

    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> eleName;
    By elementName=By.cssSelector("tr td:nth-child(3)");
    public OrdSecScr(WebDriver driver){
        super(driver);
    }
    public Boolean webView(String ProductName){
        System.out.println("Sample Statement");
        WaitForElementAppear(OrdHdSec);
        OrdHdBtn.click();
        WaitForAllEleAppear(elementName);
        Boolean Text1=eleName.stream().anyMatch(Ele -> Ele.getText().equalsIgnoreCase(ProductName));
        return Text1;

    }
}
