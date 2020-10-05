package test;

import eu.tsystems.mms.tic.testframework.pageobjects.UiElementFinder;
import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import eu.tsystems.mms.tic.testframework.testing.UiElementFinderFactoryProvider;
import eu.tsystems.mms.tic.testframework.testing.WebDriverManagerProvider;

public abstract class AbstractFinderTest extends TesterraTest implements UiElementFinderFactoryProvider, WebDriverManagerProvider {
    protected UiElementFinder getFinder() {
        return uiElementFinderFactory.create(webDriverManager.getWebDriver());
    }
}
