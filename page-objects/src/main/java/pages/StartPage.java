package pages;

import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import eu.tsystems.mms.tic.testframework.pageobjects.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class StartPage extends Page {
    private final UiElement searchField = find(By.name("q"));
    private final UiElement searchBtn = find(By.name("btnK"));

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        UiElement acceptCookieBtn = findDeep(XPath.from("span").text("Ich stimme zu")).setName("acceptCookiesBtn");
        if (acceptCookieBtn.waitFor().displayed(true)) {
            acceptCookieBtn.click();
            acceptCookieBtn.expect().present(false);
        }
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
