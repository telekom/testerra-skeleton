package pages;

import components.ResultItem;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.XPath;
import org.openqa.selenium.WebDriver;

public class ResultPage extends Page {
    private final UiElement resultContainer = find(XPath.from("div").attribute("id").is("search").contains("div").classes("g"));

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public ResultItem getResult() {
        return createComponent(ResultItem.class, resultContainer);
    }
}
