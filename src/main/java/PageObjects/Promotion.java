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
    By Title = new By.ByName("name");
    By TextArea = new By.ByXPath("(//textarea[@name='description'])[1]");
    By Discount = new By.ByXPath("//div[contains(@class,'custom-control custom-radio')]/following-sibling::input[1]");
    By PromotionCode = new By.ByName("promotion_code");
    By SelectFile = new By.ByXPath("//*[@id=\"validatedCustomFile\"]");
    By SaveButton = new By.ById("save-btn");

    public WebElement Promotions(){
        return driver.findElement(Promotions);
    }
    public WebElement AddButton(){
        return driver.findElement(AddButton);
    }
    public WebElement Title(){
        return driver.findElement(Title);
    }
    public WebElement TextArea(){
        return driver.findElement(TextArea);
    }
    public WebElement Discount(){
        return driver.findElement(Discount);
    }
    public WebElement PromotionCode(){
        return driver.findElement(PromotionCode);
    }
    public WebElement SelectFile(){
        return driver.findElement(SelectFile);
    }
    public WebElement SaveButton(){
        return driver.findElement(SaveButton);
    }


}
