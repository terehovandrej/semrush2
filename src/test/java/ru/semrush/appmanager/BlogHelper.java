package ru.semrush.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import ru.semrush.model.PostData;
import ru.semrush.model.Posts;

import java.util.List;

public class BlogHelper extends HelperBase {

    public BlogHelper(ApplicationManager app) {
        super(app);
    }


    public Posts all(PostType postType) {
        Posts posts = new Posts();
        if (postType == PostType.LARGE_CARDS) {
            List<WebElement> elements = wd.findElements(By.xpath("//div[@data-test='post-card-large']"));
        } else if (postType == PostType.SMALL_CARDS) {
            List<WebElement> elements = wd.findElements(By.xpath("//div[@data-test='post-card-small']"));
        } else if (postType == PostType.ALL_CARDS) {
            List<WebElement> elements = wd.findElements(By.xpath("//div[@data-test='post-card-small']"));
            elements.addAll(wd.findElements(By.xpath("//div[@data-test='post-card-large']")));
        }

        List<WebElement> elements = wd.findElements(By.xpath("//div[@data-test='post-card-large']"));
        for (WebElement element : elements) {
            String category = element.findElement(By.xpath(".//p[@data-test='category']/a")).getText();
            String timeToRead = element.findElement(By.xpath(".//span[@data-test='time-to-read']")).getText();
            String tittle = element.findElement(By.xpath(".//a[@data-test='title']")).getText().replaceAll("[^a-zA-Z0-9\\s]", "");
            String description = element.findElement(By.xpath(".//span[@data-test='description']")).getText().replaceAll("[^a-zA-Z0-9\\s]", "");
            String author = element.findElement(By.xpath(".//a[@data-test='author-name']/span")).getText();
            String date = element.findElement(By.xpath(".//span[@data-test='date']")).getText();
            posts.add(new PostData().withCategory(category).withTimeToRead(timeToRead).withTittle(tittle)
                    .withDescription(description).withAuthor(author).withDate(date));
        }
        return new Posts(posts);
    }

    public void checkElementPresent(String element) throws Exception {
        SoftAssert assrt = new SoftAssert();
        switch (element) {
            case "navbar" -> {
                assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='blog-navbar']//div[@data-test='logo']")));
                assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='blog-navbar']//span[text()='SEO']")));
                assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='blog-navbar']//span[text()='Content Marketing']")));
                assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='blog-navbar']//span[text()='Marketing']")));
                assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='blog-navbar']//span[text()='Paid Media']")));
                assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='blog-navbar']//span[text()='Social Media']")));
                assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='blog-navbar']//span[text()='News']")));
                assrt.assertTrue(isElementPresent(By.xpath("//a[@aria-label='Search']")));
                assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='blog-navbar']//div[@data-test='theme-switcher']")));
                assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='blog-navbar']//div[@data-test='logo']")));
            }
            case "subscription-block" -> assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='subscription-block']")));
            case "promo-widget" -> assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='promo-widget-widget']")));
            case "ebook-widget" -> assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='ebook-widget']")));
            case "trial-block" -> assrt.assertTrue(isElementPresent(By.xpath("//div[@data-test='trial-block']")));
            case "footer" -> assrt.assertTrue(isElementPresent(By.xpath("//footer[@data-test='footer']")));
            default -> throw new Exception("Element is not described");
        }
        assrt.assertAll();
    }
}

