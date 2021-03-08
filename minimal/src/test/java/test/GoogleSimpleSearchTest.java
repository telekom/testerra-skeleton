package test;

import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementFinder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GoogleSimpleSearchTest extends AbstractGoogleTest implements Loggable {

    @Test()
    public void test_Search() {
        UiElementFinder finder = createFinder();
        finder.find(By.name("q")).type("Hallo World");
        finder.find(By.name("btnK")).click();
    }
}
