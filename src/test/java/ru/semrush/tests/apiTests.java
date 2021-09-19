package ru.semrush.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.semrush.appmanager.ApiTestConfig;

import static io.restassured.RestAssured.*;

public class apiTests extends ApiTestConfig {

    @Test
    public void requestBlogGetPage() {
        given().spec(requestBlogGet).log().all()
                .when()
                .get()
                .then().spec(responseBlogGet).log().all();
    }

    @DataProvider(name = "categoryName")
    public Object[][] categoryDataProviders() {
        return new Object[][]{{"marketing"}, {"seo"}, {"content-marketing"}, {"paid-media"}, {"social-media"}};
    }

    @Test(dataProvider = "categoryName")
    public void getCategories(String categoryName) {
        given()
                .when().log().all()
                .get("category/" + categoryName)
                .then().statusCode(200);
    }
}
