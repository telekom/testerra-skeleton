package factories;

import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.DefaultPageFactory;
import eu.tsystems.mms.tic.testframework.pageobjects.IPage;
import eu.tsystems.mms.tic.testframework.pageobjects.IPageFactory;
import org.openqa.selenium.WebDriver;

public class MyPageFactory extends DefaultPageFactory implements IPageFactory, Loggable {
    @Override
    public <T extends IPage> T createPage(Class<T> pageClass, WebDriver webDriver) {
        log().info("Enjoy your custom Page");
        return super.createPage(pageClass, webDriver);
    }
}
