package com.packa;

import com.packb.*;
import com.packb.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ErrorValTest extends BaseTest {
    @Test(groups={"ErrHan"},dataProvider = "getData1")
    public void Funct1(String Email1,String Password1){
        logScr = new LogScr(driver);
        String errMsg1=logScr.InvCrd(Email1,Password1);
        Assert.assertEquals(errMsg1,"Incorrect email or password.");
    }
    @Test(dataProvider="getData2")
    public void Funct2(String Email2,String Password2, String ProdName) throws Exception {
        logScr=new LogScr(driver);
        ProdListScr prodListScr=logScr.logScreen(Email2,Password2);
        CartScreen cartScreen=prodListScr.ProductList(ProdName);
        PayMetScr payMetScr=cartScreen.Play();
        FinalScr finalScr=payMetScr.Particle();
        finalScr.TestScr();
    }
    @DataProvider
    public Object[][] getData1(){
        return new Object[][]{{"thakkarsuraj6411@gmail.com","Suraj123@"}};
    }
    @DataProvider
    public Object[][] getData2(){
        return new Object[][]{{"thakkarsuraj641@gmail.com","Suraj123@","ADIDAS ORIGINAL"}};
    }

}
