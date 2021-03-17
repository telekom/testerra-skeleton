package test;

import eu.tsystems.mms.tic.testframework.annotations.Fails;
import eu.tsystems.mms.tic.testframework.pageobjects.LocatorFactoryProvider;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementFinder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GoogleSimpleLayoutTest extends AbstractGoogleTest implements LocatorFactoryProvider {

    @Test()
    public void test_Layout() {
        UiElementFinder finder = createFinder();
        UiElement searchInput = finder.find(By.name("q"));
        UiElement searchBtn = finder.find(LOCATE.by(By.name("btnK")).displayed());
        UiElement luckyBtn = finder.find(LOCATE.by(By.name("btnI")).displayed());

        searchBtn.expect().bounds().below(searchInput).is(true);
        luckyBtn.expect().bounds().rightOf(searchBtn).is(true);
        luckyBtn.expect().bounds().fromTop().toTopOf(searchBtn).is(0);
        luckyBtn.expect().bounds().intersects(searchBtn).is(false);
    }

    @Test
    @Fails(description = "Body element does not exists anymore")
    public void test_Layout_Image() {
        UiElementFinder finder = createFinder();
        finder.find(By.id("body")).expect().screenshot().pixelDistance("GoogleBody").isLowerThan(10);
    }
}
