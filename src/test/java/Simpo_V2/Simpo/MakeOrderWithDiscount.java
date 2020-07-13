package Simpo_V2.Simpo;

import PageObjects.Dashboard;
import PageObjects.LandingPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class MakeOrderWithDiscount extends base {
    Properties prop;
    FileInputStream fis;

    private static Logger log = LogManager.getLogger(MakeOrderWithDiscount.class.getName());
    @Test
    public void OrderPercentageDiscount() throws IOException, InterruptedException {
        prop = new Properties();
        fis= new FileInputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
        prop.load(fis);
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("website"));
        WebDriverWait wait = new WebDriverWait(driver, 60);
        LandingPage LP = new LandingPage(driver);
        LP.getEmail().sendKeys(prop.getProperty("email"));
        LP.getPassword().sendKeys(prop.getProperty("password"));
        LP.LoginButton().click();
        Assert.assertEquals(LP.TabeName().getText(),"My Profile");
        if (LP.TabeName().getText().equals("My Profile")) {
            System.out.println("User Logged In successfully");
        } else {
            System.out.println("User Failed to Login");
        }
        Dashboard DB = new Dashboard(driver);
        Actions actions = new Actions(driver);
        //actions.moveToElement(DB.OrderPage()).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(DB.PlaceOrder())).click();
        log.info("Clicked on Place Order Button");
        wait.until(ExpectedConditions.visibilityOf(DB.AddProduct())).click();
        log.info("Clicked on Add Product Button");
        wait.until(ExpectedConditions.visibilityOf(DB.SupplierDropDown())).click();
        log.info("Clicked onS Supplier DropDown");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("AAAAAA");
        Thread.sleep(2500);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(Keys.RETURN);
        //wait.until(ExpectedConditions.visibilityOf(DB.SupplierName())).click();
        log.info("Selecting Supplier AAAAAA");
        Thread.sleep(2500);
        wait.until(ExpectedConditions.visibilityOf(DB.ProductDropDown())).click();
        log.info("Clicked Product Dropdown");
        wait.until(ExpectedConditions.visibilityOf(DB.SelectProduct())).click();
        log.info("Selected Refrigerator product");
        DB.Add().click();
        log.info("Clicked Add Button");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DB.Place());
        wait.until(ExpectedConditions.elementToBeClickable(DB.Place())).click();
        log.info("Clicked Place Order Button");
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOf(DB.PromotionButton())).click();
        wait.until(ExpectedConditions.visibilityOf(DB.PromotionText())).sendKeys(prop.getProperty("PercentagePromotion"));
        Thread.sleep(500);
        DB.ApplyButton().click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(DB.Confirm())).click();
        log.info("Clicked on Confirm Order Button");
        wait.until(ExpectedConditions.visibilityOf(DB.ConfirmPopUp())).click();
        log.info("Order Created Successfully");

    }


}
