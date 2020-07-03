package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Promotion {
    public WebDriver driver;
    public Promotion(WebDriver driver){
        this.driver=driver;
    }

    By Promotions = new By.ByXPath("//a[@href='/promotions']//a[1]");
    By AddButton = new By.ByCssSelector("div#main-wrapper>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>div>div>div>div>div:nth-of-type(2)>button");


    public WebElement Promotions(){
        return driver.findElement(Promotions);
    }
    public WebElement AddButton(){
        return driver.findElement(AddButton);
    }

}
