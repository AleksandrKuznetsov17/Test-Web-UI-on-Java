package ru.gb.lessons.lesson8.pages;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage {

    @Step("Проверить, что в корзине продукты: {productNames}")
    public void checkCartContainsProducts(String... productNames) {
        $(By.className("cart-table"))
                .$$x("./div//a[@class='cart-table__name']")
                .shouldHave(CollectionCondition.exactTextsCaseSensitiveInAnyOrder(productNames));
    }
}
