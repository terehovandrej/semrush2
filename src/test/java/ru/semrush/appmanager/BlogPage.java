package ru.semrush.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.semrush.model.PostData;
import ru.semrush.model.Posts;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class BlogPage {
    private final SelenideElement logo = $x("//div[@data-test='blog-navbar']//div[@data-test='logo']");
    private final SelenideElement navbar_seo = $x("//div[@data-test='blog-navbar']//span[text()='SEO']");
    private final SelenideElement navbar_content_marketing = $x("//div[@data-test='blog-navbar']//span[text()='SEO']");
    private final SelenideElement navbar_marketing = $x("//div[@data-test='blog-navbar']//span[text()='SEO']");
    private final SelenideElement navbar_paid_media = $x("//div[@data-test='blog-navbar']//span[text()='SEO']");
    private final SelenideElement navbar_social_media = $x("//div[@data-test='blog-navbar']//span[text()='SEO']");
    private final SelenideElement navbar_news = $x("//div[@data-test='blog-navbar']//span[text()='SEO']");
    private final SelenideElement search = $x("//div[@data-test='blog-navbar']//span[text()='SEO']");
    private final SelenideElement subscription_block = $("[data-test=subscription-block]");
    private final SelenideElement promo_widget_widget = $("[data-test=promo-widget-widget]");
    private final SelenideElement ebook_widget = $("[data-test=ebook-widget]");
    private final SelenideElement trial_block = $("[data-test=trial-block]");
    private final SelenideElement footer = $("[data-test=footer]");
    private final SelenideElement theme_switcher = $x("//div[@data-test='blog-navbar']//span[text()='SEO']");
    private final ElementsCollection large_cards = $$x("//div[@data-test='post-card-large']");
    private final ElementsCollection small_cards = $$x("//div[@data-test='post-card-small']");
    PostPage postPage = new PostPage();

    public void isElementPresent(String element) {
        SelenideElement selenideElement = null;
        switch (element) {
            case "logo" -> selenideElement = logo;
            case "navbar-seo" -> selenideElement = navbar_seo;
            case "navbar-content-marketing" -> selenideElement = navbar_content_marketing;
            case "navbar-marketing" -> selenideElement = navbar_marketing;
            case "navbar-paid-media" -> selenideElement = navbar_paid_media;
            case "navbar-social-media" -> selenideElement = navbar_social_media;
            case "navbar-news" -> selenideElement = navbar_news;
            case "search" -> selenideElement = search;
            case "subscription-block" -> selenideElement = subscription_block;
            case "promo-widget-widget" -> selenideElement = promo_widget_widget;
            case "ebook-widget" -> selenideElement = ebook_widget;
            case "trial-block" -> selenideElement = trial_block;
            case "footer" -> selenideElement = footer;
            case "theme-switcher" -> selenideElement = theme_switcher;
        }
        assert selenideElement != null : String.format("Element %s is not described", element);
        selenideElement.shouldBe(Condition.visible);
    }

    public ElementsCollection parsePosts(String postType) {
        if (postType.equals("large_cards"))
            return large_cards;
        else if (postType.equals("small_cards"))
            return small_cards;
        else
            throw new RuntimeException("Incorrect post_type");
    }

    public Posts allPosts(String post_type){
        Posts posts = new Posts();
        for (SelenideElement element : parsePosts(post_type)) {
            String category = postPage.parsePost(element, "category");
            String timeToRead = postPage.parsePost(element, "time-to-read");
            String tittle = postPage.parsePost(element, "title").replaceAll("[^a-zA-Z0-9\\s]", "");
            String description = postPage.parsePost(element, "description").replaceAll("[^a-zA-Z0-9\\s]", "");
            String author = postPage.parsePost(element, "author-name");
            String date = postPage.parsePost(element, "date");
            posts.add(new PostData().withCategory(category).withTimeToRead(timeToRead).withTittle(tittle)
                    .withDescription(description).withAuthor(author).withDate(date));
        }
        return new Posts(posts);
    }

    public Posts generateRefPostsFromJSON(String json_name) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(String.format("src/test/resources/%s.json", json_name));
        return mapper.readValue(file, Posts.class);
    }

}

