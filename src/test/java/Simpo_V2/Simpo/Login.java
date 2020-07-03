package Simpo_V2.Simpo;

import PageObjects.LandingPage;
import PageObjects.Signup;
import com.google.gson.internal.$Gson$Preconditions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Login extends base {
    Properties prop;
    FileInputStream fis;
    public WebDriver driver;
    private static Logger log = LogManager.getLogger(Login.class.getName());
    @Test
    public void LoginToWebSite() throws IOException, InterruptedException {
        prop = new Properties();
        fis= new FileInputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
        prop.load(fis);
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("website"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        LandingPage LP = new LandingPage(driver);
        LP.getEmail().sendKeys(prop.getProperty("AcceptConnectionEmail"));
        LP.getPassword().sendKeys(prop.getProperty("password"));
        LP.LoginButton().click();
        Assert.assertEquals(LP.TabeName().getText(),"My Profile");
        if (LP.TabeName().getText().equals("My Profile")) {
            log.fatal("User Failed to Login");
        } else {
            log.info("Test Case Login Pass: User Logged in Successfully");
        }


    }
  
}
