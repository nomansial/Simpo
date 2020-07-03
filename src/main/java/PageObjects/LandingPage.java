package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;
    By email = new By.ByXPath("(//input[contains(@class,'form-control input')])[1]");
    By password = new By.ByXPath("(//input[contains(@class,'form-control input')])[2]");
    By LoginButton = new By.ByXPath("//button[contains(@class,'btn btn-primary')]");
    By OrderPageCSS = new By.ByCssSelector("ul#sidebarnav>li:nth-of-type(4)>a>a>span");
    By TabName = new By.ById("pageTitle");

    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getEmail(){
        return driver.findElement(email);
    }
    public WebElement getPassword(){
        return driver.findElement(password);
    }
    public  WebElement LoginButton(){
        return  driver.findElement(LoginButton);
    }
    public WebElement OrderPage(){
        return driver.findElement(OrderPageCSS);
    }
    public WebElement TabeName(){
        return  driver.findElement(TabName);
    }
}
