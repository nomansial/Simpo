package Simpo_V2.Simpo;

import PageObjects.CreateProduct;
import PageObjects.LandingPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class CreateProductTest extends base {
    Properties prop;
    FileInputStream fis;
    public WebDriver driver;
    private static Logger log = LogManager.getLogger(CreateProductTest.class.getName());
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
        CreateProduct CP = new CreateProduct(driver);
        wait.until(ExpectedConditions.visibilityOf(CP.Products())).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",CP.AddButton());

        wait.until(ExpectedConditions.visibilityOf(CP.Code())).sendKeys("343"+prop.getProperty("SignUpBusinessEmail"));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(CP.name())).sendKeys("Automation"+prop.getProperty("SignUpBusinessEmail"));
        wait.until(ExpectedConditions.visibilityOf(CP.textarea())).sendKeys("This product was created by automation script..... "+prop.getProperty("SignUpBusinessEmail"));
        wait.until(ExpectedConditions.visibilityOf(CP.SelectCategory())).click();
        wait.until(ExpectedConditions.visibilityOf(CP.SelectProduct())).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(CP.Group())).click();
        CP.CPGroupSelect().click();
        wait.until(ExpectedConditions.visibilityOf(CP.SelectUOM())).click();
        CP.UOMSelect().click();

        wait.until(ExpectedConditions.visibilityOf(CP.Cost())).sendKeys(prop.getProperty("SignUpBusinessEmail"));
        CP.Price().sendKeys(prop.getProperty("SignUpBusinessEmail"));

        CP.UploadFile().sendKeys(System.getProperty("user.dir")+"\\resources\\productimage.jpg");
        Thread.sleep(1000);
        CP.SaveButton().click();



    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
  
}
