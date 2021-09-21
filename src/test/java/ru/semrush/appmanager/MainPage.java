package ru.semrush.appmanager;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement blog = $x("//a[@data-test='blog']");

    public void openMainPage() {
        String url = "https://www.semrush.com/";
        open(url);
    }

    public void goToBlog() {
        blog.click();
    }
}
