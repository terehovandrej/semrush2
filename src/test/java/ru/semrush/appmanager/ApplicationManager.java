package ru.semrush.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
    private final Properties properties;
    private WebDriver wd;
    private BlogHelper blogHelper;
    private NavigationHelper navigationHelper;

    private final String browser;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }

    public void stop() {
        if (wd != null) {
            wd.quit();
        }
    }

    public WebDriver getDriver() {
        if (wd == null) {
            switch (browser) {
                case BrowserType.CHROME -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    wd = new ChromeDriver(options);
                }
                case BrowserType.FIREFOX -> wd = new FirefoxDriver();
                case BrowserType.IE -> wd = new InternetExplorerDriver();
            }
            assert wd != null;
            wd.get(properties.getProperty("web.baseUrl"));
        }
        return wd;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public BlogHelper blog() {
        if (blogHelper == null) {
            blogHelper = new BlogHelper(this);
        }
        return blogHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper = new NavigationHelper(this);
    }
}
