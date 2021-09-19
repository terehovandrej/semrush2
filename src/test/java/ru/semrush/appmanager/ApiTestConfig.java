package ru.semrush.appmanager;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static ru.semrush.appmanager.ApiConstants.Path.SEMRUSH_PATH;
import static ru.semrush.appmanager.ApiConstants.RunVariable.*;
import static ru.semrush.appmanager.ApiConstants.Servers.SEMRUSH_URL;

public class ApiTestConfig {
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
    }

    protected RequestSpecification requestBlogGet = new RequestSpecBuilder()
            .addQueryParam("page", "3")
            .addHeader("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
            .addCookie("testCookie")
            .setBaseUri(SEMRUSH_URL + SEMRUSH_PATH)
            .build();

    protected ResponseSpecification responseBlogGet = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectHeader("content-type", "text/html; charset=utf-8")
            .build();

}
