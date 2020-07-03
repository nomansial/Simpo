package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Products {


    public WebDriver driver;
    public Products(WebDriver driver){
        this.driver=driver;
    }

    By Setup = new By.ByXPath("//a[@href='/set-up']//a[1]");
    By ProductCategory = new By.ById("ProductCategory-tab");
    By AddButton = new  By.ByXPath("(//div[contains(@class,'col-md-4 col-12')]//button)[1]");
    By name = new By.ByName("name");
    By Save = new By.ById("save-btn");
    By ProductGroup = new By.ById("ProductGroup-tab");
    By GroupAddButton = new By.ByXPath("(//div[contains(@class,'col-md-4 col-12')]//button)[3]");
    By UOM= new By.ById("uom-tab");
    By UOMAdd = new By.ByXPath("(//button[@class='btn btn-primary'])[5]");

    public WebElement Setup(){
        return driver.findElement(Setup);
    }

    public WebElement Category(){
        return driver.findElement(ProductCategory);
    }
    public  WebElement AddButton(){
        return driver.findElement(AddButton);
    }
    public  WebElement Name(){
        return driver.findElement(name);
    }
    public WebElement Save(){
        return driver.findElement(Save);
    }
    public WebElement ProductGroup(){
        return driver.findElement(ProductGroup);
    }
    public WebElement GroupAdd(){
        return driver.findElement(GroupAddButton);
    }
    public WebElement UOM(){
        return driver.findElement(UOM);
    }
    public WebElement UOMAdd(){
        return driver.findElement(UOMAdd);
    }
}
