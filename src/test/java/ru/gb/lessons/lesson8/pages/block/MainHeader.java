package ru.gb.lessons.lesson8.pages.block;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.gb.lessons.lesson8.pages.ProductPage;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainHeader {
    private final SelenideElement loginButton = $x("//div[@class='header__links']//a[div[text()='Войти']]");

    @Step("Перейти на страницу {tab1} -> {tab2}")
    public ProductPage goToProductPage(String tab1, String tab2) {
        $x("//ul[@data-type='header']//li/a[text()='" + tab1 + "']").hover();
        $x("//ul[@data-type='header']//li/a[text()='" + tab2 + "']").click();
        return page(ProductPage.class);
    }

    @Step("Проверить, что кнопка 'Войти' отображается на странице")
    public MainHeader checkLoginButtonIsVisible() {
        $x("//div[@class='header__links']//a[div[text()='Войти']]")
                .should(Condition.visible.because("Так как не авторизованы"), Duration.ofSeconds(5));
        return this;
    }

    @Step("Кликнуть на кнопку 'Войти'")
    public LoginPopup clickLoginButton() {
        loginButton.click();
        return new LoginPopup();
    }

    @Step("Кликнуть на кнопку 'Выйти'")
    public MainHeader logout() {
        $("div.header__user").click();
        $(byText("Выйти"))
                .should(Condition.visible.because("Так как авторизованы"), Duration.ofSeconds(5))
                .click();
        return new MainHeader();
    }

}
