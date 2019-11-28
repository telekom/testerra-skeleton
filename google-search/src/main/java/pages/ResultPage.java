package pages;

import components.ResultItem;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends Page {
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public ResultItem result() {
        return createComponent(ResultItem.class, find(By.xpath("//div[@class='rc']")));
    }
}
