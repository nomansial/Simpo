package Simpo_V2.Simpo;

import PageObjects.LandingPage;
import PageObjects.Signup;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SignUpTest extends base {
    Properties prop;
    FileInputStream fis;
    FileOutputStream out;
    FileOutputStream ConnectionCompanyName;
    public WebDriver driver;

    private static Logger log = LogManager.getLogger(Login.class.getName());

    @Test
    public void SignUpNewUser() throws IOException, InterruptedException {
        prop = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\data.properties");
        prop.load(fis);
        fis.close();
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("website"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        Signup SP = new Signup(driver);
        wait.until(ExpectedConditions.visibilityOf(SP.SignUp())).click();
        log.info("Clicked on Singup Link");
        String emailcount = prop.getProperty("SignUpEmail");
        wait.until(ExpectedConditions.visibilityOf(SP.EmailField())).sendKeys("Selenium" + emailcount + "@yopmail.com");
        out = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\data.properties");
        int EmailCounter = Integer.parseInt(emailcount);
        int EmailCounterAddOne = EmailCounter + 1;
        prop.setProperty("SignUpEmail", String.valueOf(EmailCounterAddOne));
        prop.store(out, null);
        log.info("Updated email counter");
        SP.Password().sendKeys("Test@123");
        SP.ConfirmPassword().sendKeys("Test@123");
        log.info("Entering Password Test@123");
        WebElement Country = SP.MobileNumber();
        Select CountryCode = new Select(Country);
        CountryCode.selectByVisibleText("+91");
        SP.MobileNum().sendKeys("374837261" + emailcount);
        Select CountryCode2 = new Select(SP.Office());
        CountryCode2.selectByVisibleText("+91");
        SP.OfficeTel().sendKeys("446254831" + emailcount);
        wait.until(ExpectedConditions.visibilityOf(SP.NextButton())).click();
        log.info("Clicked on Next button after filling up Sign Up form");
        //////////////////////////////////////OTP///////////////////////////////////////
        WebElement OTP1 = driver.findElement(By.xpath("//input[@data-next='digit-2']"));
        wait.until(ExpectedConditions.visibilityOf(OTP1)).sendKeys("1");
        WebElement OTP2 = driver.findElement(By.xpath("//input[@data-next='digit-3']"));
        OTP2.sendKeys("2");
        WebElement OTP3 = driver.findElement(By.xpath("//input[@data-next='digit-4']"));
        OTP3.sendKeys("3");
        WebElement OTP4 = driver.findElement(By.xpath("//input[@data-next='digit-5']"));
        OTP4.sendKeys("4");
        WebElement OTP5 = driver.findElement(By.xpath("//input[@data-next='digit-6']"));
        OTP5.sendKeys("5");
        WebElement OTP6 = driver.findElement(By.cssSelector("input#digit-6"));
        OTP6.sendKeys("6");
        ////////////////////////////////////////////////////////////////////////////////
        SP.UserType().click();
        SP.NextButtonOT().click();
        Thread.sleep(2000);
        SP.First().sendKeys("Sele");
        Thread.sleep(2000);
        SP.First().sendKeys("nium" + emailcount);
        SP.Last().sendKeys("User");
        String CompanyName = "Supplier" + emailcount;
        ConnectionCompanyName = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\data.properties");
        prop.setProperty("ConnectionCompany", CompanyName);
        prop.store(ConnectionCompanyName, null);
        Thread.sleep(500);
        SP.Comp().sendKeys(CompanyName);
        Thread.sleep(500);
        SP.UEN().sendKeys(emailcount + "741302Q");
        SP.Verify().click();
        Thread.sleep(500);
        SP.Address().sendKeys("Dummy Address Line One");
        wait.until(ExpectedConditions.visibilityOf(SP.Country())).click();

        //actions.moveToElement(DB.OrderPage()).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(SP.SelectThailand())).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(SP.SelectState())).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(SP.SelectBangKok())).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(SP.City())).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(SP.SelectCityy())).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(SP.PostCode())).sendKeys("343234");
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(SP.Same())).click();
        Thread.sleep(900);
        SP.FinishButton().click();
        log.info("User created successfully");


    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
