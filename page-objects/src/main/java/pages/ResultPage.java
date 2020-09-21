package pages;

import components.ResultItem;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.XPath;
import org.openqa.selenium.WebDriver;

public class ResultPage extends Page {
    private UiElement resultContainer = find(XPath.from("div").classes("rc"));

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public ResultItem result() {
        return createComponent(ResultItem.class, resultContainer);
    }
}
