package factories;

import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.DefaultPageFactory;
import eu.tsystems.mms.tic.testframework.pageobjects.PageObject;
import eu.tsystems.mms.tic.testframework.pageobjects.PageObjectFactory;
import org.openqa.selenium.WebDriver;

public class MyPageFactory extends DefaultPageFactory implements PageObjectFactory, Loggable {
    @Override
    public <T extends PageObject> T createPage(Class<T> pageClass, WebDriver webDriver) {
        log().info("Enjoy your custom Page");
        return super.createPage(pageClass, webDriver);
    }
}
