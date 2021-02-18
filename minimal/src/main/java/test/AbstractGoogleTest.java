package test;

import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.LocatorFactoryProvider;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementFinder;
import eu.tsystems.mms.tic.testframework.pageobjects.XPath;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractGoogleTest extends AbstractFinderTest implements Loggable, LocatorFactoryProvider {

    @BeforeMethod
    public void acceptCookies() {
        UiElement acceptCookiesBtn = finder.findDeep(XPath.from("span").text("Ich stimme zu"));
        if (acceptCookiesBtn.waitFor().displayed(true)) {
            acceptCookiesBtn.click();
        }
    }
}
