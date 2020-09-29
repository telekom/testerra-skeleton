package pages;

import eu.tsystems.mms.tic.testframework.pageobjects.internal.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class StartPage extends Page {
    private UiElement searchField = find(By.name("q"));
    private UiElement searchBtn = find(By.name("btnK"));

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public StartPage type(String string) {
        searchField.type(string);
        return this;
    }

    public ResultPage searchByEnter() {
        searchField.sendKeys(Keys.ENTER);
        return createPage(ResultPage.class);
    }

    public ResultPage searchByDefaultButton() {
        searchBtn.click();
        return createPage(ResultPage.class);
    }

    public ResultPage searchLucky() {
        find(By.className("RNmpXc")).click();
        return createPage(ResultPage.class);
    }
}
