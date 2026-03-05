package com.packb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProdListScr extends AbstractClass {

    @FindBy(css = "div.mb-3")
    List<WebElement> ProdLists;
    @FindBy(css = "button:last-of-type")
    WebElement AddToCartBtn;
    By ProductLists=By.cssSelector("div.mb-3");

    By ProductName=By.cssSelector("div h5 b");
    By AddCrtButton=By.cssSelector("button:last-of-type");

    By Spinner=By.cssSelector(".ngx-spinner-overlay");

    By ToastMsg=By.cssSelector("div#toast-container");

    public ProdListScr(WebDriver driver){
        super(driver);
    }
    public CartScreen ProductList(String Product){
        WaitForAllEleApp(ProdLists);
        WebElement ele1=ProdLists.stream().filter(ele -> ele.findElement(ProductName).getText().equalsIgnoreCase(Product)).findFirst().orElse(null);
        ele1.findElement(AddCrtButton).click();
        WaitForElementAppear(ToastMsg);
        waitForSpinnerToDisappear(Spinner);
        WaitForEleClick(CartHeadBtn);
        CartScreen cartScreen=new CartScreen(driver);
        return cartScreen;
    }
}
