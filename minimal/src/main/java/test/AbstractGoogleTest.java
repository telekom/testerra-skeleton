package test;

import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.UiElementFinder;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractGoogleTest extends AbstractFinderTest implements Loggable {

    @BeforeMethod
    public void acceptCookies() {
        UiElementFinder finder = getFinder();
        UiElement acceptCookiesBtn = finder.findByLabel("button", "Ich stimme zu");
        if (acceptCookiesBtn.waitFor().displayed(true)) {
            acceptCookiesBtn.click();
        }
    }
}
