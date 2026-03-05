package com.packb.TestComponents;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packb.LogScr;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LogScr logScr;

    public WebDriver InitializeDriver() throws Exception {
        Properties props = new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "globalData.properties");
        props.load(fs);
        String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):props.getProperty("browser");
      //String browserName = props.getProperty("browser");
        if (browserName.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (browserName.contains("headless")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));

        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    else if (browserName.equalsIgnoreCase("safari")) {
        driver = new SafariDriver();
    }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File SourceFile = ts.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(System.getProperty("user.dir") + File.separator + "reports" + File.separator + testCaseName + File.separator + "Sample.png");
        FileUtils.copyFile(SourceFile, DestFile);
        return System.getProperty("user.dir") + File.separator + "reports"  +File.separator+ testCaseName + File.separator + "Sample.png";
    }

    public List<HashMap<String, String>> retrieveData(String pathName) throws IOException {
        String FilePath = FileUtils.readFileToString(new File(pathName), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(FilePath, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    @BeforeMethod(alwaysRun = true)
    public LogScr launchApp() throws Exception {
        driver = InitializeDriver();
        LogScr logScr = new LogScr(driver);
        logScr.goTo();
        return logScr;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


