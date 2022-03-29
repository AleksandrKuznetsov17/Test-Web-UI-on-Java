package ru.gb.lessons.lesson8.defs;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.gb.lessons.lesson8.pages.CartPage;
import ru.gb.lessons.lesson8.pages.MainPage;
import ru.gb.lessons.lesson8.pages.ProductPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.gb.lessons.lesson8.config.TestConfig.testConfig;

public class MyStepdefs {
    @Given("Product page is loaded")
    public void productPageIsLoaded() {
        Configuration.baseUrl = testConfig.url();
        Configuration.timeout = 5000;
        Configuration.browser = "chrome";
        Configuration.browserSize = "2000x1500";
        open("/");
    }

    @When("User goes to {string} {string}")
    public void userGoesTo(String arg0, String arg1) {
        new MainPage().getHeader()
                .goToProductPage(arg0, arg1);
    }

    @And("User select {string}")
    public void userSelect(String arg0) {
        new ProductPage().selectProduct(arg0);
    }

    @And("User goes to cart")
    public void userGoesToCart() {
        new ProductPage().goToCart();
    }

    @Then("Cart contains {string}")
    public void cartContains(String arg0) {
        new CartPage().checkCartContainsProducts(arg0);
    }
}
