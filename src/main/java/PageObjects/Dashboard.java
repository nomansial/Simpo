package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
    public WebDriver driver;
    By OrderPageCSS = new By.ByCssSelector("ul#sidebarnav>li:nth-of-type(4)>a>a");
    By OrderPage = new By.ByXPath("//a[@href='/connections']//a[2]");
    By PlaceOrder = new By.ByXPath("(//button[contains(@class,'btn btn-primary')])[1]");
    By AddProduct = new By.ByXPath("(//button[@type='button'])[4]");
    By SupplierDropDown = new By.ByXPath("(//div[@class='multiselect__select'])[1]");
    By SupplierName = new By.ByXPath("//span[text()='AAAAAA']");
    By ProductDropDown = new By.ByXPath("(//div[@class='multiselect__tags'])[2]");
    By SelectProduct = new By.ByXPath("//span[text()='Samsung Refrigerator']");
    By Add = new By.ByXPath("(//button[contains(@class,'btn btn-primary')])[5]");
    By Place = new By.ByXPath("(//button[contains(@class,'btn btn-primary')])[4]");
    By Confirm = new By.ByXPath("(//button[contains(@class,'btn btn-primary')])[5]");
    By ConfirmPopUp = new By.ByXPath("(//button[text()='Yes'])[3]");

    public Dashboard(WebDriver driver) {

        this.driver=driver;
    }
    public WebElement OrderPage(){
        return driver.findElement(OrderPageCSS);
    }
    public  WebElement PlaceOrder(){
        return driver.findElement(PlaceOrder);
    }
    public WebElement AddProduct(){
        return driver.findElement(AddProduct);
    }
    public WebElement SupplierDropDown(){
        return  driver.findElement(SupplierDropDown);
    }
    public  WebElement SupplierName(){
        return  driver.findElement(SupplierName);
    }
    public  WebElement ProductDropDown(){
        return driver.findElement(ProductDropDown);
    }
    public WebElement SelectProduct(){
        return  driver.findElement(SelectProduct);
    }
    public  WebElement Add(){
        return driver.findElement(Add);
    }
    public  WebElement Place(){
        return driver.findElement(Place);
    }
    public  WebElement Confirm(){
        return driver.findElement(Confirm);
    }
    public WebElement ConfirmPopUp(){
        return driver.findElement(ConfirmPopUp);
    }
}
