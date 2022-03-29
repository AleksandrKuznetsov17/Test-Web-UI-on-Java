package ru.gb.lessons.lesson8.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ProductPage extends BasePage {

    private final SelenideElement goToCartButton = $x("//*[contains(text(),'Перейти в корзину')]");

    @Step("Добавить товар {productName} в корзину")
    public ProductPage selectProduct(String productName) {
        $x("//div[@class='product-card ' and contains(., '" + productName + "')]")
                .$(By.className("product-card__btn")).click();
        return this;
    }

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        goToCartButton.click();
        return page(CartPage.class);
    }
}
