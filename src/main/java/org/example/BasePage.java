package org.example;

import org.example.utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.Normalizer;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public void clickToElement(WebElement locator) {
        waifRorElementToBeClickable(locator);
        locator.click();
        Utils.logInfo("click to element:" + locator);  // ეს მეთოდი აკლიკებს ელემენტს


    }

    public void waitForElementToBeVisible(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        Utils.logInfo("waiting element" + locator); // ამ მეთოდის გამოძახების შემდეგ ეს დაელოდება 10 წამი იმ კონკრეტულ ელემენტს რომელსაც გადმოვცემ

    }

    public void enterText(WebElement locator, String text) {
        waitForElementToBeVisible(locator);
        locator.sendKeys(text);
        Utils.logInfo("sendkey:  [ " + text + " ] to element: " + locator); // ამ მეთოდში გადაცემულია ვებელემენტი  და ტექსტი
        // რომელ ელემენტში რა ტექსტი უნდა ჩაწეროს

    }

    public void waifRorElementToBeClickable(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Utils.logInfo("waiting " + locator + "if it is clickable"); // ეს მეთოდი ამოწმებს ელემენტი დაკლიკებადია თუ არა


    }

    public void waitElementLonger(WebElement locator, int second) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOf(locator));
        Utils.logInfo("waiting element" + locator);

    }

    public void assertEquals(String expected, String actual) {
        Assert.assertEquals(actual, expected); // ამ მეთოდში ასერშენი ადარებს ორ url ერთმანეთს

    }

    public void assertEquals(String expectedUrl, String actualUrl, String message) {
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    public void refreshPage() {
        driver.navigate().refresh();
        Utils.logInfo("refresh page" + driver.getCurrentUrl()); // ეს მეთოდი არეფრეშებს მიმდინარე გვერდს


    }


    public String getTextFromElement(WebElement locator) { // ეს მეთოდი დამიბრუნებს იმ ელემენტის ტექსტს რასაც გადავცემ
        waitForElementToBeVisible(locator);
        Utils.logInfo("Text founded" + locator.getText());
        return locator.getText();

    }


    public void scrollToElement(WebElement element) {
        waitForElementToBeVisible(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        Utils.logInfo("Scrolled to element: " + element);
    }

    public void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }


}
