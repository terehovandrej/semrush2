package ru.semrush.tests;

import org.testng.annotations.Test;
import ru.semrush.appmanager.BlogPage;
import ru.semrush.appmanager.MainPage;
import ru.semrush.model.Posts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestSemrushBlogPage extends MainPage {
    MainPage mainPage = new MainPage();
    BlogPage blogPage = new BlogPage();

    @Test
    public void SemrushBlogElements() {
        mainPage.openMainPage();
        mainPage.goToBlog();
        blogPage.isElementPresent("logo");
        blogPage.isElementPresent("navbar-seo");
        blogPage.isElementPresent("navbar-content-marketing");
        blogPage.isElementPresent("navbar-marketing");
        blogPage.isElementPresent("navbar-paid-media");
        blogPage.isElementPresent("navbar-social-media");
        blogPage.isElementPresent("navbar-news");
        blogPage.isElementPresent("search");
        blogPage.isElementPresent("subscription-block");
        blogPage.isElementPresent("promo-widget-widget");
        blogPage.isElementPresent("trial-block");
        blogPage.isElementPresent("footer");
        blogPage.isElementPresent("theme-switcher");
    }

    @Test
    public void PostsContentPreview() throws Exception {
        Posts referencePosts = blogPage.generateRefPostsFromJSON("large_cards");
        mainPage.openMainPage();
        mainPage.goToBlog();
        Posts factPosts = blogPage.allPosts("large_cards");
        assertThat(referencePosts, equalTo(factPosts));

    }
}

