package test;

import eu.tsystems.mms.tic.testframework.pageobjects.LocatorFactoryProvider;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.UiElementFinder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SimpleGoogleLayoutTest extends AbstractGoogleTest implements LocatorFactoryProvider {

    @Test()
    public void test_Layout() {
        UiElementFinder finder = getFinder();
        UiElement searchInput = finder.find(Locate.by(By.name("q")).displayed());
        UiElement searchBtn = finder.find(Locate.by(By.name("btnK")).displayed());
        UiElement luckyBtn = finder.find(Locate.by(By.name("btnI")).displayed());

        searchBtn.expectThat().bounds().below(searchInput).is(true);
        luckyBtn.expectThat().bounds().rightOf(searchBtn).is(true);
        luckyBtn.expectThat().bounds().fromTop().toTopOf(searchBtn).is(0);
        luckyBtn.expectThat().bounds().intersects(searchBtn).is(true);
    }

    @Test
    public void test_Layout_Image() {
        UiElementFinder finder = getFinder();
        finder.find(By.id("body")).expectThat().screenshot().pixelDistance("GoogleBody").isLowerThan(10);
    }
}
