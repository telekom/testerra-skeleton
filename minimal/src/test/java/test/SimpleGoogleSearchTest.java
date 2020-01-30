package test;

import eu.tsystems.mms.tic.testframework.report.TesterraListener;
import eu.tsystems.mms.tic.testframework.testing.UiElementCreator;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TesterraListener.class})
public class SimpleGoogleSearchTest implements UiElementCreator {

    @Test()
    public void test_Search() {
        find(By.name("q")).clear().sendKeys("Hallo World");
        find(By.name("btnK")).click();
    }

    @Override
    public WebDriver getWebDriver() {
        return WebDriverManager.getWebDriver();
    }
}
