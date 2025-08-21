package org.example.tests;

import org.example.BasePage;
import org.example.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.ProductDetailsPage;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {

    @Test
    public void addToWishlist() { // ავტორიცაზიის შემდეგ ,ეძებს ნივთს და მოძებნილ ნივთს ამატებს სურვილების სიაში
        LoginPage loginPage = new LoginPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        loginPage.login(username, password);
        productDetailsPage.addItemToWishList(wishlistProductName);
        productDetailsPage.verifyItemInWishlist();
        productDetailsPage.assertEquals(wishlistProductPrice, productDetailsPage.getItemPrice());
    }


    @Test
    public void deleteProductFromWishlist() {
        // ავტორიზაციის შემდეგ , აკლიკებს ღილაკს ჩემ ველს , შემდეგ სურვილებს და სურვილებიდან შლის დამატებულ ნივთს
        LoginPage loginPage = new LoginPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        loginPage.login(username, password);
        productDetailsPage.verifyItemInWishlist();
        productDetailsPage.deleteButton();
        productDetailsPage.assertEquals(emptyWishlistText, productDetailsPage.getTextFromElement());

    }

}
