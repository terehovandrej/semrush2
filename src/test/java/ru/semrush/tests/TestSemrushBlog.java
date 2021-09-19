package ru.semrush.tests;

import org.testng.annotations.Test;
import ru.semrush.model.PostData;
import ru.semrush.model.Posts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.semrush.appmanager.PostType.*;

public class TestSemrushBlog extends TestBase{

    @Test
    public void SemrushBlogElements() throws Exception {
        app.goTo().blog();
        app.blog().checkElementPresent("navbar");
        app.blog().checkElementPresent("subscription-block");
        app.blog().checkElementPresent("promo-widget");
        app.blog().checkElementPresent("ebook-widget");
        app.blog().checkElementPresent("trial-block");
        app.blog().checkElementPresent("footer");
        app.goTo().home();

    }

    @Test
    public void PostsContentPreview() throws Exception {
        Posts referencePosts = new Posts();
        referencePosts.add(new PostData()
                .withCategory("Content Marketing")
                .withTimeToRead("10 min read")
                .withTittle("How to Get Traffic to Your Blog in 2021 A Beginners Guide")
                .withDescription("Attracting highvalue traffic to a new blog is not easy but it is doable Discover six actionable ways to drive the audience to your brand new blog")
                .withAuthor("Sion Phillpott")
                .withDate("Sep 03, 2021"));
        referencePosts.add(new PostData()
                .withCategory("Paid Media")
                .withTimeToRead("11 min read")
                .withTittle("Mobile Advertising Get Insights to Target the Right Audience")
                .withDescription("Nearly 75 of the average persons internet time is on mobile so getting mobile ads right is crucial Learn all you need to know to create mobile ads that are tailormade for your customer and will increase your return on ad spend")
                .withAuthor("Kelly Lyons")
                .withDate("Sep 01, 2021"));
        app.goTo().blog();
        Posts factPosts = app.blog().all(LARGE_CARDS);
        assertThat(referencePosts, equalTo(factPosts));
        app.goTo().home();

    }
}
