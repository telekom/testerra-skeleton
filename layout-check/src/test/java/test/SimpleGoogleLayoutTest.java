package test;

import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import eu.tsystems.mms.tic.testframework.testing.UiElementCreator;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SimpleGoogleLayoutTest extends TesterraTest implements UiElementCreator {

    @Test()
    public void test_Layout() {
        UiElement searchInput = find(Locate.by(By.name("q")).displayed());
        UiElement searchBtn = find(Locate.by(By.name("btnK")).displayed());
        UiElement luckyBtn = find(Locate.by(By.name("btnI")).displayed());

        searchBtn.bounds().below(searchInput).is(true);
        luckyBtn.bounds().rightOf(searchBtn).is(true);
        luckyBtn.bounds().fromTop().toTopOf(searchBtn).is(0);
        luckyBtn.bounds().intersects(searchBtn).is(true);
    }

    @Test
    public void test_Layout_Image() {
        find(By.id("body")).screenshot().pixelDistance("GoogleBody").isLowerThan(10);
    }
}
