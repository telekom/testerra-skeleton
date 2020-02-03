package test;

import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.StartPage;

public class GoogleSearchTest extends TesterraTest {

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void test_Search() {
        StartPage startPage = pageFactory.createPage(StartPage.class);
        ResultPage resultPage = startPage.type("testerra").searchByEnter();
        resultPage.result().list().first().headline().text().contains("Testerra");
    }

}
