package ru.gb.lessons.lesson8.pages;

import ru.gb.lessons.lesson8.pages.block.MainHeader;

public class BasePage {

    public MainHeader getHeader() {
        return new MainHeader();
    }
}
