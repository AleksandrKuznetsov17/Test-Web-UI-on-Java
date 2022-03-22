package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.pages.block.MainHeader;

public class BasePage extends BaseView {

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainHeader getHeader() {
        return new MainHeader(webDriver);
    }
}
