import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.StartPage;

public class GoogleSearchTest extends TesterraTest {

    StartPage startPage;

    @BeforeClass
    private void prepare() {
        startPage = pageFactory.createPage(StartPage.class);
    }

    @Test
    public void test_Search() {
        ResultPage resultPage = startPage.search("testerra");
        resultPage.result(1).headline().text().contains("Testerra");
    }

}
