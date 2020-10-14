package test;

import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.Aria;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementFinder;
import org.testng.annotations.Test;

public class GoogleAriaSearchTest extends AbstractGoogleTest implements Loggable {

    @Test
    public void test_Search_by_Labels() {
        UiElementFinder finder = getFinder();
        finder.findByLabel(Aria.TEXTBOX, "Suche").highlight().sendKeys("MMS Dresden");
        finder.findByLabel(Aria.BUTTON, "Google Suche").highlight().click();
    }
}
