package test;

import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.XPath;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractGoogleTest extends AbstractFinderTest {

    @BeforeMethod
    public void acceptCookies() {
        UiElement acceptCookiesBtn = createFinder().findDeep(XPath.from("button").text("Ich stimme zu"));
        if (acceptCookiesBtn.waitFor().displayed(true)) {
            acceptCookiesBtn.click();
        }
    }
}
