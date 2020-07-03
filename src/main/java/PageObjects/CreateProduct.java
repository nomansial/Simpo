package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateProduct {


    public WebDriver driver;
    public CreateProduct(WebDriver driver){
        this.driver=driver;
    }

    By Products = new By.ByXPath("//a[@href='/products']//a[1]");
    By AddButton = new By.ByCssSelector("div#main-wrapper>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>div>div>div>div>div:nth-of-type(2)>button");
    By Code = new By.ByName("code");
    By SelectProduct = new By.ByCssSelector("div#main-wrapper>div:nth-of-type(2)>div>div>div>div>div>div>div:nth-of-type(4)>div:nth-of-type(2)>div>div>div:nth-of-type(3)>ul>li:nth-of-type(6)>span");
    By name = new By.ByName("name");
    By textarea = new By.ByXPath("//div[@class='col-lg-8']//textarea[1]");
    By Category = new By.ByXPath("(//div[@class='multiselect__tags'])[1]");
    By Group = new By.ByXPath("(//div[@class='multiselect__tags'])[3]");
    By SelectUOM = new By.ByXPath("(//div[@class='multiselect__tags'])[5]");
    By Cost = new By.ByName("cost");
    By CPGroupSelect = new By.ByXPath("//span[text()='Home']");
    By UOMSelect = new By.ByXPath("//span[text()='test']");
    By Price = new By.ByName("price");
    By SelectFile = new By.ByXPath("//*[@id=\"validatedCustomFile\"]");
    By SaveButton = new By.ById("save-btn");

    public WebElement Products(){
        return driver.findElement(Products);
    }
    public WebElement AddButton(){
        return driver.findElement(AddButton);
    }
    public WebElement Code(){
        return driver.findElement(Code);
    }
    public WebElement name(){
        return driver.findElement(name);
    }
    public WebElement textarea(){
        return driver.findElement(textarea);
    }
    public WebElement SelectCategory(){
        return driver.findElement(Category);
    }
    public WebElement Group(){
        return driver.findElement(Group);
    }
    public WebElement SelectUOM(){
        return driver.findElement(SelectUOM);
    }
    public WebElement Cost(){
        return driver.findElement(Cost);
    }
    public WebElement SelectProduct(){
        return driver.findElement(SelectProduct);
    }
    public WebElement CPGroupSelect(){
        return driver.findElement(CPGroupSelect);
    }
    public WebElement UOMSelect(){
        return driver.findElement(UOMSelect);
    }
    public WebElement Price(){
        return driver.findElement(Price);
    }
    public WebElement UploadFile(){
        return driver.findElement(SelectFile);
    }
    public WebElement SaveButton(){
        return driver.findElement(SaveButton);
    }



}
