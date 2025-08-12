package org.example;

import org.example.utils.ConfigReader;
import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
   protected WebDriver driver;

 /* protected String baseUrl;
  protected String username;
   protected String password; */

    @BeforeMethod
    public void setup() {
    /* baseUrl = ConfigReader.get("baseUrl");
       username = ConfigReader.get("username");
       password = ConfigReader.get("password");
       System.out.println("Base URL: " + baseUrl);  */

        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
         // driver.get(baseUrl);  ეს არ მუშაობს

     // ConfigReader.get("baseUrl"); // ეს არ მუშაობს
  driver.get("https://veli.store/"); // ეს მუშაობს

    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

}





