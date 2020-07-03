package Simpo_V2.Simpo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver;
    Properties prop;
    FileInputStream fis;
    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        fis= new FileInputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
        prop.load(fis);
        String browserName= prop.getProperty("browser");
        System.out.println(browserName);

        if(browserName.equals("FireFox")){
            System.setProperty("webdriver.gecko.driver",prop.getProperty("fireFoxDriverPath"));
            driver = new FirefoxDriver();
        }
        else if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);
            }
        else if (browserName.equals("Opera")){
            System.setProperty("webdriver.edge.driver",prop.getProperty("Opera"));
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                return driver;
    }

    public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= formatter.format(date);
        System.out.println(strDate);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\Results\\"+testMethodName+"-"+strDate+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;
    }



}
