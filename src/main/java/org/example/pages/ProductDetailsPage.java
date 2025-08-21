package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='რას ეძებ?']")
    WebElement searchInput;

    @FindBy(className = "search-submit")
    WebElement searchButton;

    @FindBy(linkText = "Apple AirPods Max Wireless Over-Ear Headphones Orange")
    WebElement selectSecondItem;

    @FindBy(className = "wishlist-btn")
    WebElement wishListButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/header/div[4]/div[1]/div[3]/button[2]")
    WebElement loginMenuButton;

    @FindBy(xpath = "//a[contains(text(),'სურვილები')]")
    WebElement wishesButton;

    @FindBy(id = "cart-button-x")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='main']//span[1]")
    WebElement itemPrice;

    @FindBy(className = "remove")
    WebElement removeBtn;

    @FindBy( css = "div[class='content'] h2")
    WebElement textFromElement;


    public void addItemToWishList(String productName) {
        searchInput.clear();
        enterText(searchInput, productName);
        clickToElement(searchButton);
        clickToElement(selectSecondItem);
        clickToElement(wishListButton);
    }


    public void verifyItemInWishlist() {
        clickToElement(loginMenuButton);
        clickToElement(wishesButton);

    }

    public String getItemPrice()  {
       return getTextFromElement(itemPrice).trim(); }

    public void deleteButton() {
        clickToElement(removeBtn); }


    public String getTextFromElement() {
        return getTextFromElement(textFromElement);
    }
}