package test;

import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.UiElementFinder;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleGoogleSearchTest extends AbstractGoogleTest implements Loggable {

    @Test()
    public void test_Search() {
        UiElementFinder finder = getFinder();
        finder.find(By.name("q")).type("Hallo World");
        finder.find(By.name("btnK")).click();
    }

    @Test
    public void test_Search_by_Labels() {
        UiElementFinder finder = getFinder();
        finder.findByLabel("input", "Suche").highlight().sendKeys("MMS Dresden");
        finder.findByLabel("button", "Google Suche").highlight().click();
    }
}
