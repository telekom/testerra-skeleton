package test;

import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.testing.PageFactoryProvider;
import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.StartPage;

public class GoogleSearchTest extends TesterraTest implements PageFactoryProvider {

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void test_Search() {
        StartPage startPage = PAGE_FACTORY.createPage(StartPage.class);

        startPage.acceptCookies();
        ResultPage resultPage = startPage.type("testerra").searchByEnter();

        CONTROL.withTimeout(1, () -> {
            UiElement headline = resultPage.getResult().list().first().headline();
            headline.expect().text().contains("Testerra");
            headline.click();
        });
    }

}
