package components;

import eu.tsystems.mms.tic.testframework.pageobjects.AbstractComponent;
import eu.tsystems.mms.tic.testframework.pageobjects.IGuiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.TestableGuiElement;
import org.openqa.selenium.By;

public class ResultItem extends AbstractComponent<ResultItem> {
    public ResultItem(IGuiElement rootElement) {
        super(rootElement);
    }

    @Override
    protected ResultItem self() {
        return this;
    }

    public TestableGuiElement headline() {
        return find(By.className("S3Uucc"));
    }
}
