package org.example;

import org.example.utils.ConfigReader;
import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    protected String baseUrl;
    protected String username;
    protected String password;
    protected String wrongPassword;
    protected String productName;
    protected String productPrice;
    protected String wishlistProductName;
    protected String wishlistProductPrice;
    protected String emptyCartText;
    protected String emptyWishlistText;
    protected String passwordLengthError;


    @BeforeMethod
    public void setup() {
        baseUrl = ConfigReader.get("baseUrl");
        username = ConfigReader.get("username");
        password = ConfigReader.get("password");
        wrongPassword = ConfigReader.get("wrongPassword");
        productName = ConfigReader.get("productName");
        productPrice = ConfigReader.get("productPrice");
        wishlistProductName = ConfigReader.get("wishlistProductName");
        wishlistProductPrice = ConfigReader.get("wishlistProductPrice");
        emptyCartText = ConfigReader.get("emptyCartText");
        emptyWishlistText = ConfigReader.get("emptyWishlistText");
        passwordLengthError = ConfigReader.get("passwordLengthError");


        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        ConfigReader.get(baseUrl);


    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

}





