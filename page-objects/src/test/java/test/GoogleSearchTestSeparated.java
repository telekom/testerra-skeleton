package test;

import eu.tsystems.mms.tic.testframework.pageobjects.InteractiveUiElement;
import eu.tsystems.mms.tic.testframework.testing.PageFactoryProvider;
import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import eu.tsystems.mms.tic.testframework.testing.WebDriverManagerProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.StartPage;

/**
 * This test demonstrates how to use WebDrivers over several tests using exclusive sessions.
 * @author Mike Reiche
 */
public class GoogleSearchTestSeparated extends TesterraTest implements
        PageFactoryProvider,
        WebDriverManagerProvider
{

    private String exclusiveSessionKey;

    private synchronized WebDriver getExclusiveWebDriver() {
        WebDriver webDriver;
        if (exclusiveSessionKey == null) {
            webDriver = WEB_DRIVER_MANAGER.getWebDriver();
            this.exclusiveSessionKey = WEB_DRIVER_MANAGER.makeExclusive(webDriver);
        } else {
            webDriver = WEB_DRIVER_MANAGER.getWebDriver(this.exclusiveSessionKey);
        }
        return webDriver;
    }

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void test_Search() {
        WebDriver webDriver = getExclusiveWebDriver();
        StartPage startPage = PAGE_FACTORY.createPage(StartPage.class, webDriver);

        startPage.acceptCookies();
        startPage.type("testerra").searchByEnter();
    }

    @Test(dependsOnMethods = "test_Search")
    public void test_CheckResults() {
        WebDriver webDriver = getExclusiveWebDriver();
        ResultPage resultPage = PAGE_FACTORY.createPage(ResultPage.class, webDriver);

        InteractiveUiElement headline = resultPage.getResult().list().first().getHeadline();
        headline.expect().text().contains("Testerra").is(true);
        headline.click();

        WEB_DRIVER_MANAGER.shutdownSession(webDriver);
    }
}
