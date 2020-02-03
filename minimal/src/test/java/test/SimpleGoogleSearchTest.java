package test;

import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import eu.tsystems.mms.tic.testframework.testing.UiElementCreator;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SimpleGoogleSearchTest extends TesterraTest implements UiElementCreator {

    @Test()
    public void test_Search() {
        find(By.name("q")).type("Hallo World");
        find(By.name("btnK")).click();
    }
}
