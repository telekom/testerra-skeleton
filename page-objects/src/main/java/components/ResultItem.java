package components;

import eu.tsystems.mms.tic.testframework.pageobjects.AbstractComponent;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import org.openqa.selenium.By;

public class ResultItem extends AbstractComponent<ResultItem> {
    public ResultItem(UiElement rootElement) {
        super(rootElement);
    }

    @Override
    protected ResultItem self() {
        return this;
    }

    public UiElement headline() {
        return find(By.tagName("h3"));
    }
}
