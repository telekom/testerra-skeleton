package components;

import eu.tsystems.mms.tic.testframework.pageobjects.AbstractComponent;
import eu.tsystems.mms.tic.testframework.pageobjects.InteractiveUiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import org.openqa.selenium.By;

public class ResultItem extends AbstractComponent<ResultItem> {
    public ResultItem(UiElement rootElement) {
        super(rootElement);
    }

    public InteractiveUiElement getHeadline() {
        return find(By.tagName("h3"));
    }
}
