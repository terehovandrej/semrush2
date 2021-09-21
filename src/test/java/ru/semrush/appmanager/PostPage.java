package ru.semrush.appmanager;

import com.codeborne.selenide.SelenideElement;

public class PostPage {
    public String parsePost(SelenideElement post, String data_test){
        return post.$(String.format("[data-test='%s']", data_test)).getText();
    }
}
