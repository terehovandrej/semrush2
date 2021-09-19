package ru.semrush.appmanager;

import org.openqa.selenium.By;


public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }


    public void blog() {
        click(By.xpath("//a[@data-test='blog']"));
    }

    public void home() throws InterruptedException {
        click(By.xpath("//a[@data-test='logo-link-main']"));
        switchWindow(1);
    }
}
