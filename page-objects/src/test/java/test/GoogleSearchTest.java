package test;

import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.testing.PageFactoryProvider;
import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.StartPage;

/**
 * This test demonstrates how to use PageObjects in your test.
 * @author Mike Reiche
 */
public class GoogleSearchTest extends TesterraTest implements PageFactoryProvider {

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void test_Search() {
        StartPage startPage = PAGE_FACTORY.createPage(StartPage.class);

        startPage.acceptCookies();
        startPage.type("testerra").searchByEnter();

        ResultPage resultPage = startPage.createPage(ResultPage.class);
        UiElement headline = resultPage.getResult().list().first().getHeadline();
        headline.expect().text().contains("Testerra");
        headline.click();
    }
}
