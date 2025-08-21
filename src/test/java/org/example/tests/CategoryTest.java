package org.example.tests;

import org.example.BaseTest;
import org.example.pages.CategoryPage;
import org.example.pages.LoginPage;
import org.example.utils.ConfigReader;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    //ამ მეთოდში ხდება ავტორიზაცია სწორი მონაცემებით
    //სერჩში ეძებს ნივთს , ჩამოსქროლავს ქვევით და ამატებს ნივთს კალათაში
    //შემდეგ ხსნის კალათას და ამოწმებს ფასს
    @Test
    public void addProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        loginPage.login(username, password);
        categoryPage.addItemToCart(productName);
        categoryPage.assertEquals(productPrice, categoryPage.getProductPrice());
    }

    @Test
// ამ მეთოდში ხდება ავტორიზაცია , შემდეგ აკლიკებს კალათის ღილაკს , დაკლიკების შემდეგ იხსნება კალათის ფანჯარა,
// აკლიკებს წაშლის აიქონს და ნივთი იშლება  კალათიდან
    public void removeItemFromCart() { //
        LoginPage loginPage = new LoginPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        loginPage.login(username, password);
        categoryPage.deleteItemFromCart();
        categoryPage.assertEquals(emptyCartText, categoryPage.getEmptyCartText());
    }

}








