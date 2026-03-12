package com.packb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogScr extends AbstractClass {


    public LogScr(WebDriver driver){
        super(driver);

    }
    @FindBy(id="userEmail")
    WebElement UserEmail;
    @FindBy(css="input#userPassword")
    WebElement PassWord;
    @FindBy(name="login")
    WebElement logBtn;
    @FindBy(css = "div[class*='flyInOut']")
            WebElement errMsg;
    By EmailTxtFld=By.id("userEmail");
    By PasswordTxtFld=By.cssSelector("input#userPassword");
    By LoginButton=By.name("login");
    public ProdListScr logScreen(String Text1, String Text2){

        WaitForElementAppear(EmailTxtFld);
        UserEmail.sendKeys(Text1);
        WaitForElementAppear(PasswordTxtFld);
        PassWord.sendKeys(Text2);
        WaitForElementAppear(LoginButton);
        logBtn.click();
        ProdListScr prodListScr=new ProdListScr(driver);
        return prodListScr;
    }
    public String InvCrd(String emailId, String passId ){
        System.out.println("Delete the statement");
        WaitForElementAppear(EmailTxtFld);
        UserEmail.sendKeys(emailId);
        WaitForElementAppear(PasswordTxtFld);
        PassWord.sendKeys(passId);
        WaitForElementAppear(LoginButton);
        logBtn.click();
        WaitForEleToAppear(errMsg);
        return errMsg.getText();
    }
    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");

    }
    public void DeleteFunc(){
        System.out.println("Delete the statement");
        System.out.println("Delete the statement");
        System.out.println("Delete the statement");
        System.out.println("Delete the statement");
        System.out.println("Delete the statement");
    }
}
