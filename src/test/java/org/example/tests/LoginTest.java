package org.example.tests;

import org.example.BaseTest;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Test
    public void testValidLogin() {  // ავტორიზაცია სწორი მეილით და პაროლით
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        loginPage.assertTrue(loginPage.isMyAccountVisible(), "ჩემი ველი ღილაკი არ ჩანს ლოგინის შემდეგ");
        loginPage.refreshPage();
        loginPage.assertTrue(loginPage.isMyAccountVisible(), "მომხმარებელი არ რჩება დალოგინებული გვერდის განახლების შემდეგ");
    }


    @Test
    public void testLoginWithInvalidPassword() {  // აავტორიზაცია სწორი მეილით და არასწორი პაროლით
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, wrongPassword);
        loginPage.assertEquals(passwordLengthError, loginPage.passwordLengthError());
    }


}
