package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/header/div[4]/div[1]/div[3]/button[2]")
    WebElement loginMenuButton;

    @FindBy(id = "sigin-email")
    WebElement usernameField;

    @FindBy(id = "signin-password")
    WebElement passwordField;

    @FindBy(css = ".styled__AuthPrimaryBtn-mh0716-2.dCwCil")
    WebElement loginButton;

    @FindBy(css = "div[class='error'] span")
    WebElement errorMessage;

    @FindBy(xpath = "//button[contains(text(),'ჩემი ველი')]")
    WebElement myAccount;


    public void login(String username, String password) {
        clickToElement(loginMenuButton);
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickToElement(loginButton);
    }


    public String passwordLengthError() {

        return getTextFromElement(errorMessage);
    }

    public boolean isMyAccountVisible() {
        waitForElementToBeVisible(myAccount);
        return myAccount.isDisplayed();
    }

}









