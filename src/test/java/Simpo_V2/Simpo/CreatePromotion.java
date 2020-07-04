package Simpo_V2.Simpo;

import PageObjects.LandingPage;
import PageObjects.Promotion;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;


public class CreatePromotion extends base {
    Properties prop;
    FileInputStream fis;
    public WebDriver driver;
    private static Logger log = LogManager.getLogger(CreatePromotion.class.getName());
    @Test
    public void LoginToWebSite() throws IOException, InterruptedException {
        prop = new Properties();
        fis= new FileInputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
        prop.load(fis);
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("website"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        LandingPage LP = new LandingPage(driver);
        LP.getEmail().sendKeys(prop.getProperty("AcceptConnectionEmail"));
        LP.getPassword().sendKeys(prop.getProperty("password"));
        LP.LoginButton().click();
        Assert.assertEquals(LP.TabeName().getText(),"My Profile");
        if (LP.TabeName().getText().equals("My Profile")) {
            log.fatal("User Failed to Login");
        } else {
            log.info("Test Case Login Pass: User Logged in Successfully");
        }

        Promotion PR = new Promotion(driver);
        wait.until(ExpectedConditions.visibilityOf(PR.Promotions())).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",PR.AddButton());

        PR.Title().sendKeys("Automation"+prop.getProperty("SignUpBusinessEmail"));
        PR.TextArea().sendKeys("This promotion was created by selenium automation script");
        PR.Discount().sendKeys("10");



        Calendar cal = Calendar.getInstance();
        int DayOfMonth=cal.get(Calendar.DAY_OF_MONTH);
        String FormatedDay= Integer.toString(DayOfMonth);
        WebElement StartDate = driver.findElement(By.xpath("(//input[@name='date'])[1]"));
        StartDate.click();
        WebElement FirstCalender = driver.findElement(By.cssSelector("div.mx-calendar-content tbody"));
        List<WebElement> columns = FirstCalender.findElements(By.tagName("td"));

        for(WebElement date :columns){
            String days = date.getAttribute("data-day");
            if(FormatedDay.equals(days)){
                Thread.sleep(1000);
                date.click();
                break;
            }

        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateIs= formatter.format(date);
        try {
            cal.setTime(formatter.parse(dateIs));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Add number of Days
        String numberOfDays=prop.getProperty("NumberOfDaysToAddInPromotion");
        cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(numberOfDays));
        String newDate = formatter.format(cal.getTime());
        System.out.println("First Formatted Date" + newDate );
        /////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////
        System.out.println("Second Formateed Date is "+newDate);
        String[] splited = newDate.split("-");
        String Year=splited[0]; String Month = splited[1]; String Day = splited[2];
        System.out.println("Date before adding days "+dateIs );
        System.out.println("Date After adding days "+newDate );
        System.out.println("Month for Calender is "+Month );
        System.out.println("Year for Calender is "+Year );
        System.out.println("Day for Calender is "+Day );
        ///////////////////////////////////////////////////////////////////////////////////
        String MonthFromCurrentDate =null;
        if(Month.equals("01")){
            MonthFromCurrentDate="Jan";
        }
        else if(Month.equals("02")){
            MonthFromCurrentDate="Feb";
        }
        else if(Month.equals("03")){
            MonthFromCurrentDate="Mar";
        }
        else if(Month.equals("04")){
            MonthFromCurrentDate="Apr";
        }
        else if(Month.equals("05")){
            MonthFromCurrentDate="May";
        }
        else if(Month.equals("06")){
            MonthFromCurrentDate="Jun";
        }
        else if(Month.equals("07")){
            MonthFromCurrentDate="Jul";
        }
        else if(Month.equals("08")){
            MonthFromCurrentDate="Aug";
        }
        else if(Month.equals("09")){
            MonthFromCurrentDate="Sep";
        }
        else if(Month.equals("10")){
            MonthFromCurrentDate="Oct";
        }
        else if(Month.equals("11")){
            MonthFromCurrentDate="Nov";
        }
        else if(Month.equals("12")){
            MonthFromCurrentDate="Dec";
        }
        System.out.println("Converted moth to charce is "+MonthFromCurrentDate);

        ///////////////////////////////////////////////////////////////////////////////////
        WebElement EndDate = driver.findElement(By.xpath("(//input[@name='date'])[2]"));
        EndDate.click();
        Thread.sleep(1000);
        WebElement year = driver.findElement(By.xpath("(//button[contains(@class,'mx-btn mx-btn-text')]/following-sibling::button)[4]"));
        String comapreyear= year.getText();
        Thread.sleep(1000);
        WebElement month = driver.findElement(By.xpath("(//button[contains(@class,'mx-btn mx-btn-text')])[5]"));
        String comparemonth=month.getText();

        WebElement SecondCalender = driver.findElement(By.cssSelector("html>body>div:nth-of-type(3)>div>div>div>div:nth-of-type(2)>table:nth-of-type(3)>tbody"));
        String compare=null;
        String SecondDays2 = null;
        Boolean check=false;

        for(int i=0;i<13;i++) {
            if(check.equals(true)){
                break;
            }
            else if (Year.equals(comapreyear) && MonthFromCurrentDate.equals(comparemonth)) {
                System.out.println("Year and Month are equal");
                List<WebElement> Secondcolumns = SecondCalender.findElements(By.tagName("td"));
                Thread.sleep(1000);
                WebElement SecondCalender1 = driver.findElement(By.cssSelector("html>body>div:nth-of-type(3)>div>div>div>div:nth-of-type(2)>table:nth-of-type(3)>tbody"));
                List<WebElement> Secondcolumns1 = SecondCalender1.findElements(By.tagName("td"));
                for (WebElement Seconddate : Secondcolumns1) {
                    String SecondDays = Seconddate.getAttribute("title");
                    System.out.println(SecondDays);
                    if (newDate.equals(SecondDays)) {
                        Seconddate.click();
                        break;
                    }

                }

            } else if (SecondDays2!=newDate){
                System.out.println("Both are not equal");
                WebElement nextButton = driver.findElement(By.xpath("(//button[contains(@class,'mx-btn mx-btn-text')]/following-sibling::button)[3]"));
                Thread.sleep(1000);
                WebElement nextButton2 = driver.findElement(By.xpath("(//button[contains(@class,'mx-btn mx-btn-text')]/following-sibling::button)[3]"));

                nextButton2.click();
                List<WebElement> Secondcolumns2 = SecondCalender.findElements(By.tagName("td"));
                Thread.sleep(1000);
                WebElement SecondCalender2 = driver.findElement(By.cssSelector("html>body>div:nth-of-type(3)>div>div>div>div:nth-of-type(2)>table:nth-of-type(3)>tbody"));
                List<WebElement> Secondcolumns3 = SecondCalender2.findElements(By.tagName("td"));
                for (WebElement Seconddate : Secondcolumns3) {
                    SecondDays2 = Seconddate.getAttribute("title");
                    if (newDate.equals(SecondDays2)) {
                        Seconddate.click();
                        check=true;
                        break;
                    }
                }
            }
        }
        WebElement PublishDate = driver.findElement(By.xpath("(//input[@name='date'])[3]"));
        PublishDate.click();
        WebElement PublishCalender = driver.findElement(By.cssSelector("html>body>div:nth-of-type(3)>div>div>div>div:nth-of-type(2)>table:nth-of-type(3)>tbody"));
        List<WebElement> PublishColumns = PublishCalender.findElements(By.tagName("td"));
        Thread.sleep(900);
        WebElement PublishCalender2 = driver.findElement(By.cssSelector("html>body>div:nth-of-type(3)>div>div>div>div:nth-of-type(2)>table:nth-of-type(3)>tbody"));
        List<WebElement> PublishColumns2 = PublishCalender2.findElements(By.tagName("td"));

        for(WebElement Pubdate :PublishColumns2){
            String days = Pubdate.getAttribute("data-day");
            if(FormatedDay.equals(days)){
                Thread.sleep(500);
                Pubdate.click();
                break;
            }

        }

        PR.PromotionCode().sendKeys("Automation"+prop.getProperty("SignUpBusinessEmail"));
        PR.SelectFile().sendKeys(System.getProperty("user.dir")+"\\resources\\productimage.jpg");
        Thread.sleep(1000);
        PR.SaveButton().click();

    }

  
}
