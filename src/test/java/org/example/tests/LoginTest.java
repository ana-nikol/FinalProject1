package org.example.tests;

import org.example.BaseTest;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
@Test
    public void testValidLogin() {  // ავტორიზაცია სწორი მეილით და პაროლით
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("proddevtest72@gmail.com","Test-2025" );
       loginPage.refreshPage();
      loginPage.assertEquals(loginPage.getCurrentUrl(), "https://veli.store/");
}



    @Test
    public void testLoginWithInvalidPassword() {  // აავტორიზაცია სწორი მეილით და არასწორი პაროლით
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("proddevtest72@gmail.com","a@378!" );
        loginPage.assertEquals("პაროლი უნდა შეიცავდეს მინიმუმ 8 სიმბოლოს" , loginPage.passwordLengthError());
    }


}
