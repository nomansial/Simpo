package Simpo_V2.Simpo;

import PageObjects.Signup;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MakeConnectionRequestTest extends base {
    Properties prop;
    FileInputStream fis;
    FileOutputStream out;
    FileOutputStream Subtract;
    FileOutputStream WriteEmail;
    public WebDriver driver;
    int EmailCounterAddOne;
    String SentConnectionEmail;
    private static Logger log = LogManager.getLogger(Login.class.getName());
    @Test
    public void MakeNewConnectaion() throws IOException, InterruptedException {

        prop = new Properties();
        fis= new FileInputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
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
        String emailcount=prop.getProperty("SignUpBusinessEmail");
        wait.until(ExpectedConditions.visibilityOf(SP.EmailField())).sendKeys("BusinessSelenium"+emailcount+"@yopmail.com");
        out = new FileOutputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
        int EmailCounter = Integer.parseInt(emailcount);
        EmailCounterAddOne = EmailCounter+1;
        prop.setProperty("SignUpBusinessEmail", String.valueOf(EmailCounterAddOne));
        prop.store(out,null);

        log.info("Updated email counter");
        SP.Password().sendKeys("Test@123");
        SP.ConfirmPassword().sendKeys("Test@123");
        log.info("Entering Password Test@123");
        WebElement Country=SP.MobileNumber();
        Select CountryCode = new Select(Country);
        CountryCode.selectByVisibleText("+91");
        SP.MobileNum().sendKeys("333837261"+emailcount);
        Select CountryCode2 = new Select(SP.Office());
        CountryCode2.selectByVisibleText("+91");
        SP.OfficeTel().sendKeys("433254831"+emailcount);
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
        Thread.sleep(900);
        SP.BusinessType().click();

        SP.NextButtonOT().click();
        Thread.sleep(2000);
        SP.First().sendKeys("Sele");
        Thread.sleep(2000);
        SP.First().sendKeys("nium"+emailcount);
        SP.Last().sendKeys("User");
        String CompanyName="Supplier"+emailcount;
        Thread.sleep(500);
        SP.Comp().sendKeys(CompanyName);
        Thread.sleep(500);
        SP.UEN().sendKeys(emailcount+"72413Q");
        SP.Verify().click();
        Thread.sleep(2000);
        SP.Address().sendKeys("Dummy Address Line One");
        wait.until(ExpectedConditions.visibilityOf(SP.Country())).click();
        Thread.sleep(2000);
       //actions.moveToElement(DB.OrderPage()).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(SP.SelectThailand())).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(SP.SelectState())).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(SP.SelectBangKok())).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(SP.City())).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(SP.SelectCityy())).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(SP.PostCode())).sendKeys("343234");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(SP.Same())).click();
        Thread.sleep(1000);
        SP.FinishButton().click();


        WebElement Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pageTitle")));
        String GetTitle=Title.getText();
        if(GetTitle.equals("My Profile")) {
            log.info("User created successfully");
            System.out.println("User created successfully");
        }
        else {System.out.println("Account not created");}

            wait.until(ExpectedConditions.visibilityOf(SP.MakeConnectionButton())).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOf(SP.NewConnectionButton())).click();

            ///////////////////////////////////////////////////////////////////////////////
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOf(SP.ConnectionCompany())).click();
            Thread.sleep(2000);
            WebElement EnterComapny = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
            driver.findElement(By.id("name")).sendKeys(prop.getProperty("ConnectionCompanyone"));
            Thread.sleep(3000);
            driver.findElement(By.id("name")).sendKeys(Keys.RETURN);
            Thread.sleep(2000);
            WebElement emaildropdown=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='multiselect__tags'])[3]")));
            String getEmail=emaildropdown.getText();
            System.out.println("email is........."+getEmail);


            WriteEmail = new FileOutputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
            prop.setProperty("AcceptConnectionEmail", String.valueOf(getEmail));
            prop.store(out,null);
                Thread.sleep(2000);
            driver.findElement(By.id("save-btn")).click();
        }




}
