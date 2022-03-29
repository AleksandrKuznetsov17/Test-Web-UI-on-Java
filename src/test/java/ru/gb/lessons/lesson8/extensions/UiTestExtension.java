package ru.gb.lessons.lesson8.extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.gb.lessons.lesson8.pojo.User;

import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.open;
import static ru.gb.lessons.lesson8.config.TestConfig.testConfig;

public class UiTestExtension implements BeforeAllCallback, AfterEachCallback, BeforeEachCallback {


    public final static String LOGIN = testConfig.login();
    public final static String PASSWORD = testConfig.password();
    public final static User user = new User(LOGIN, PASSWORD);

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        WebDriverRunner.clearBrowserCache();
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        Configuration.baseUrl = testConfig.url();
        Configuration.timeout = 5000;
        Configuration.browser = "chrome";
        Configuration.browserSize = "2000x1500";
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        open("/");
        SelenideLogger.addListener("AllureListener", new AllureSelenide().savePageSource(true).screenshots(true).enableLogs(LogType.BROWSER, Level.WARNING));
    }
}
