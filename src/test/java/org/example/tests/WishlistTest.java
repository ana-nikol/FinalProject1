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
        ProductDetailsPage productDetailsPage =  new ProductDetailsPage(driver);
        loginPage.login("proddevtest72@gmail.com","Test-2025" );
        productDetailsPage.addItemToWishList("Airpods");
        productDetailsPage.verifyItemInWishlist();
        productDetailsPage.assertEquals("2099.00 ₾", productDetailsPage.getItemPrice());
}


@Test
    public void deleteProductFromWishlist() {
    // ავტორიზაციის შემდეგ , აკლიკებს ჩემ ველს , შემდეგ სურვილებს და სურვილებიდან შლის დამატებულ ნივთს
    LoginPage loginPage = new LoginPage(driver);
    ProductDetailsPage productDetailsPage =  new ProductDetailsPage(driver);
    loginPage.login("proddevtest72@gmail.com","Test-2025" );
    productDetailsPage.verifyItemInWishlist();
    productDetailsPage.deleteButton();
   productDetailsPage.assertEquals("დახურულ სიაში პროდუქტები არ გაქვს",productDetailsPage.getTextFromElement());

}

}
