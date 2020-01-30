package test;

import eu.tsystems.mms.tic.testframework.report.TesterraListener;
import eu.tsystems.mms.tic.testframework.testing.PageObjectCreator;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.StartPage;

@Listeners({TesterraListener.class})
public class GoogleSearchTest implements PageObjectCreator {

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void test_Search() {
        StartPage startPage = PAGE_FACTORY.createPage(StartPage.class);
        ResultPage resultPage = startPage.type("testerra").searchByEnter();
        resultPage.result().list().first().headline().text().contains("Testerra");
    }

}
