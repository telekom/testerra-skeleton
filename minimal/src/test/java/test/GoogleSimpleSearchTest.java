package test;

import eu.tsystems.mms.tic.testframework.pageobjects.Locator;
import eu.tsystems.mms.tic.testframework.pageobjects.LocatorFactoryProvider;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementFinder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GoogleSimpleSearchTest extends AbstractGoogleTest implements LocatorFactoryProvider {

    @Test()
    public void test_Search() {
        // Always find displayed elements
        LOCATE.setConfigurator(Locator::displayed);

        UiElementFinder finder = createFinder();
        finder.find(By.name("q")).type("Hallo World");
        finder.find(By.name("btnK")).click();
    }
}
