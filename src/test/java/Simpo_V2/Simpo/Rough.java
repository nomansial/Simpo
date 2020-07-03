package Simpo_V2.Simpo;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Rough extends base{
    Properties prop;
    FileInputStream fis;
    FileOutputStream out;

    @Test
    public void ReadValues() throws IOException {
    prop = new Properties();
    fis= new FileInputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
    prop.load(fis);
    System.out.println(prop.getProperty("SignUpEmail"));


    out = new FileOutputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
    prop.setProperty("SignUpEmail","4");
    prop.store(out,null);



    System.out.println(prop.getProperty("SignUpEmail"));




    }

}
