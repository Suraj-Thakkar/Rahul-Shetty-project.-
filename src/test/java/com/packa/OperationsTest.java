package com.packa;
import com.packb.*;
import com.packb.TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public  class OperationsTest extends BaseTest {


    @Test(dataProvider = "getData")
    public void Func3(HashMap<String,String> input) throws Exception {
        LogScr logScr=new LogScr(driver);
        ProdListScr prodListScr=logScr.logScreen(input.get("Email"),input.get("Password"));
        CartScreen cartScreen=prodListScr.ProductList(input.get("ProductName"));
        PayMetScr payMetScr=cartScreen.Play();
        FinalScr finalScr=payMetScr.Particle();
        String finMess=finalScr.TestScr();
        Assert.assertTrue(finMess.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }
    @Test(dependsOnMethods = {"Func3"},dataProvider = "getData")
    public void Func4(HashMap<String, String> input1){
        LogScr logScr=new LogScr(driver);
        ProdListScr prodListScr=logScr.logScreen(input1.get("Email"),input1.get("Password"));
        OrdSecScr ordSecScr=new OrdSecScr(driver);
        Boolean Result=ordSecScr.webView(input1.get("ProductName"));
        Assert.assertTrue(Result);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
       /* HashMap<String,String> map1=new HashMap<>();
        map1.put("Email","surajqaprofessional624@gmail.com");
        map1.put("Password","Suraj123@");
        map1.put("ProductName","ADIDAS ORIGINAL");
        return new Object[][]{{map1}};*/
        List<HashMap<String, String>> data1 = retrieveData(System.getProperty("user.dir") + "/src/test/java/com/packc/PurchaseOrder.json");
        return new Object[][]{{data1.get(0)}};
    }
}

