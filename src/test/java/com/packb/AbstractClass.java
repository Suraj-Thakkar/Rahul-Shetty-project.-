package com.packb;

import com.packb.TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractClass  {
    protected WebDriver  driver;
    protected WebDriverWait wait;
    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement CartHeadBtn;
    @FindBy(css = "button[routerlink='/dashboard/myorders']")
    WebElement OrdHdBtn;
    By CrtHdBtn = By.xpath("//button[@routerlink='/dashboard/cart']");
    By OrdHdSec = By.cssSelector("button[routerlink='/dashboard/myorders']");
    By spinner = By.cssSelector(".ngx-spinner-overlay");

    public AbstractClass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);
    }

    public void WaitForElementAppear(By ele) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
    }
    public void WaitForEleToAppear(WebElement ele){
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void WaitForAllEleApp(List<WebElement> ele) {
        wait.until(ExpectedConditions.visibilityOfAllElements(ele));

    }

    public void WaitForEleClick(WebElement ele) {
        try {
            waitForSpinnerToDisappear(spinner);
            wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", ele);
        }
    }

    public void waitForSpinnerToDisappear(By ele) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
    }

    public void WaitForAllEleAppear(By ele) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));
    }
}


