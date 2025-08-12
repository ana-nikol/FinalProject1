package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);// სუპერით ვწვდები მშობელი კლასის ცვლადებს და მეთოდებს
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='რას ეძებ?']")
    WebElement searchInput;

    @FindBy(className = "search-submit")
    WebElement searchButton;

    @FindBy(xpath = "//a[@class='img-box product-img-link']//img[@alt='Apple iPhone 16 Pro Max 8 GB 256 GB Natural Titanium']")
    WebElement selectFirstItem;

    @FindBy(id = "cart-button-z")
    WebElement addtoCartButton;

    @FindBy(id = "cart-button")
    WebElement myCart;

    @FindBy(css = "div.prices span.price")
    WebElement priceElement;

    @FindBy(className = "delete")
    WebElement deleteButton;

    @FindBy(className = "empty")
    WebElement cartIsEmpty;




    public void addItemToCart(String productName) {
        searchInput.clear();
        enterText(searchInput, productName);   // აქ ტექსტი იწერება
        clickToElement(searchButton);                   // აქ ხდება ღილაკზე დაჭერა
        clickToElement(selectFirstItem);
        scrollToElement(addtoCartButton);
        clickToElement(addtoCartButton);
        clickToElement(myCart);
      }

    public void deleteItemFromCart() {
        clickToElement(myCart);
        clickToElement(deleteButton);
    }

    public String getProductPrice() {
        return getTextFromElement(priceElement).trim();
    }

    public String getEmptyCartText() {
        return getTextFromElement(cartIsEmpty);
    }

}




