package test;

import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import factories.MyPageFactory;
import org.testng.annotations.Test;
import pages.StartPage;

public class FactoriesTest extends TesterraTest {
    @Test
    public void test_PageFactory() {
        Assert.assertTrue(pageFactory instanceof MyPageFactory);
        pageFactory.createPage(StartPage.class);
    }

}
