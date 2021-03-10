package test;

import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementFinder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GoogleSimpleLayoutTest extends AbstractGoogleTest {

    @Test()
    public void test_Layout() {
        UiElementFinder finder = createFinder();
        UiElement searchInput = finder.find(By.name("q"));
        UiElement searchBtn = finder.find(By.name("btnK"));
        UiElement luckyBtn = finder.find(By.name("btnI"));

        searchBtn.expect().bounds().below(searchInput).is(true);
        luckyBtn.expect().bounds().rightOf(searchBtn).is(true);
        luckyBtn.expect().bounds().fromTop().toTopOf(searchBtn).is(0);
        luckyBtn.expect().bounds().intersects(searchBtn).is(false);
    }

    @Test
    public void test_Layout_Image() {
        UiElementFinder finder = createFinder();
        finder.find(By.id("body")).expect().screenshot().pixelDistance("GoogleBody").isLowerThan(10);
    }
}
