package ru.gb.lessons.lesson6;

import org.junit.jupiter.api.Test;
import ru.gb.lessons.lesson6.pages.MainPage;
import ru.gb.lessons.lesson6.pages.block.LoginPopup;

public class LoginAndLogoutTest extends BaseTest {

    @Test
    void loginAndLogout() {
        new MainPage(webDriver)
                .getHeader()
                .clickLoginButton()
                .login(LOGIN, PASSWORD)
                .logout()
                .checkLoginButtonIsVisible();
    }

    @Test
    void incorrectPasswordTest() {
        LoginPopup loginPopup = new MainPage(webDriver)
                .getHeader()
                .clickLoginButton();
        loginPopup.login(LOGIN, "incorrectPassword");
        loginPopup.checkErrorIsVisible("Неверный логин или пароль.");
    }
}
