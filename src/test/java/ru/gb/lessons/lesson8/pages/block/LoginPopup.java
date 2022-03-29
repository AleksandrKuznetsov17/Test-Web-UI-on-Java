package ru.gb.lessons.lesson8.pages.block;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WrapsElement;
import ru.gb.lessons.lesson8.pojo.User;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPopup implements WrapsElement {
    @Getter
    private final SelenideElement wrappedElement = $(By.xpath("//div[@class='popup-login__tab is-active']"));

    @Step("Авторизоваться юзером {user.login} {user.password}")
    public MainHeader login(User user) {
        return login(user.getLogin(), user.getPassword());
    }

    @Step("Авторизоваться юзером {login} {password}")
    public MainHeader login(String login, String password) {
        getWrappedElement().$(By.name("USER_LOGIN")).sendKeys(login);
        getWrappedElement().$(By.name("USER_PASSWORD")).sendKeys(password);
        getWrappedElement().$(By.xpath(".//button[span[text()='Войти']]")).click();
        return new MainHeader();
    }

    public void checkErrorIsVisible(String errorText) {
        $x("//span[@class='errortext']")
                .shouldHave(Condition.exactText(errorText).because("Был указан некорректный пароль"), Duration.ofSeconds(5));
    }
}
