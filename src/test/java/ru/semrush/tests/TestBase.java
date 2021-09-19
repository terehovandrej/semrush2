package ru.semrush.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import ru.semrush.appmanager.ApplicationManager;

import java.io.IOException;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeTest
  public void setUp() throws Exception {
    app.init();
  }

  @AfterTest(alwaysRun = true)
  public void tearDown() throws IOException {
    app.stop();
  }

}
