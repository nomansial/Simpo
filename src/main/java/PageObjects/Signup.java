package PageObjects;

import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Signup {
    public WebDriver driver;


    By SignUp = new By.ByLinkText("Sign Up");
    By EmailField = new By.ByXPath("//input[@placeholder='Email']");
    By Password = new By.ByXPath("(//input[@type='password'])[1]");
    By ConfirmPassword = new By.ByXPath("(//input[@type='password'])[2]");
    By MobileNumber = new By.ByXPath("(//select[@class='select-option'])[1]");
    By MobileNum = new By.ByXPath("(//div[@class='input-group mb-0']//input)[1]");
    By Office = new By.ByXPath("(//select[@class='select-option'])[2]");
    By OfficeTel = new By.ByXPath("(//div[@class='input-group mb-0']//input)[2]");
    By NextButton = new By.ByXPath("(//button[@type='button'])[2]");
    By OTPVerification = new By.ByXPath("(//div[@class='col-lg-2']/following-sibling::div)[1]");
    By Type = new By.ByXPath("(//button[@type='button'])[3]");
    By BusinessType = new By.ByXPath("//div[@class='user-type-list d-flex']//button[1]");
    By NextButtonOTP= new By.ByXPath("(//button[@type='button'])[5]");
    By FirstName = new By.ByXPath("(//div[contains(@class,'col-lg-6 mb-lg-0')]//input)[1]");
    By LastName = new By.ByXPath("(//div[@class='col-lg-6']//input)[1]");
    By UEN = new By.ByXPath("//div[@class='col-md-8']//input[1]");
    By Company = new By.ByXPath("//input[@placeholder='Company']");
    By AddressLineOne = new By.ByXPath("(//input[@placeholder='Address 1'])[1]");
    By Country = new By.ByXPath("(//div[@class='multiselect__tags'])[1]");
    By SelectCountry = new By.ByXPath("(//span[text()='Thailand'])[1]");
    By State = new By.ByXPath("(//div[@class='multiselect__select'])[2]");
    By SelectState = new By.ByXPath("//span[text()='Bangkok']");
    By City = new By.ByXPath("(//div[@class='multiselect__select'])[3]");
    By SelectCity = new By.ByXPath("//span[text()='Buriram']");
    By SameAddress = new By.ByXPath("//label[contains(@class,'custom-control-label text-dark')]");
    By Verify = new By.ByXPath("//button[@class='btn btn-outline-info']");
    By PostCode = new By.ByXPath("(//div[@class='col-lg-6']//input)[4]");
    By Finish = new By.ByXPath("//div[@class='col-6 text-right']//button[1]");
    By MakeConnectionButton = new By.ByXPath("//a[@href='/connections']//a[1]");
    By NewConnectionButton = new By.ByXPath("//div[contains(@class,'col-md-4 col-12')]//a[1]");

    By ConnectionCompany = new By.ByXPath("(//div[@class='multiselect__select']/following-sibling::div)[1]");
    By AcceptConnection= new By.ByXPath("(//button[@type='button'])[5]");
    public Signup(WebDriver driver) {

        this.driver=driver;
    }

    public WebElement SignUp(){
        return driver.findElement(SignUp);
    }
    public WebElement EmailField(){
        return driver.findElement(EmailField);
    }
    public WebElement Password(){
        return driver.findElement(Password);
    }
    public WebElement ConfirmPassword(){
        return driver.findElement(ConfirmPassword);
    }
    public WebElement MobileNumber(){
        return driver.findElement(MobileNumber);
    }


    public WebElement MobileNum(){
        return driver.findElement(MobileNum);
    }
    public WebElement Office(){
        return driver.findElement(Office);
    }
    public WebElement OfficeTel(){
        return driver.findElement(OfficeTel);
    }
    public WebElement NextButton(){
        return driver.findElement(NextButton);
    }
    public WebElement UserType(){
        return driver.findElement(Type);
    }
    public WebElement BusinessType(){
        return driver.findElement(BusinessType);
    }
    public  WebElement NextButtonOT(){
        return driver.findElement(NextButtonOTP);
    }
    public WebElement First(){
        return driver.findElement(FirstName);
    }
    public WebElement Last(){
        return driver.findElement(LastName);
    }
    public WebElement UEN(){
        return driver.findElement(UEN);
    }
    public WebElement Verify(){
        return driver.findElement(Verify);
    }
    public WebElement Comp(){
        return driver.findElement(Company);
    }
    public WebElement Address(){
        return driver.findElement(AddressLineOne);
    }
    public WebElement Country(){
        return driver.findElement(Country);
    }
    public WebElement SelectThailand(){
        return driver.findElement(SelectCountry);
    }
    public WebElement SelectState(){
        return driver.findElement(State);
    }
    public WebElement SelectBangKok(){
        return driver.findElement(SelectState);
    }
    public WebElement City(){return driver.findElement(City);}
    public WebElement SelectCityy(){
        return driver.findElement(SelectCity);
    }
    public WebElement PostCode(){
        return driver.findElement(PostCode);
    }
    public WebElement Same(){
        return driver.findElement(SameAddress);
    }
    public  WebElement FinishButton(){
        return driver.findElement(Finish);
    }
    public WebElement MakeConnectionButton(){
        return driver.findElement(MakeConnectionButton);
    }
    public WebElement NewConnectionButton(){
        return driver.findElement(NewConnectionButton);
    }
    public WebElement ConnectionCompany(){
        return driver.findElement(ConnectionCompany);
    }
    public WebElement AcceptConnectionButton()
    {
        return driver.findElement(AcceptConnection);
    }


}
