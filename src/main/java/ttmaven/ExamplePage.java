/*
 * Created on 17.02.2020
 *
 * Copyright(c) 1995 - 2007 T-Systems Multimedia Solutions GmbH
 * Riesaer Str. 5, 01129 Dresden
 * All rights reserved.
 */
package ttmaven;

import eu.tsystems.mms.tic.testframework.pageobjects.Check;
import eu.tsystems.mms.tic.testframework.pageobjects.GuiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Sample Description goes here.
 * <p>
 * Date: 17.02.2020
 * Time: 12:41
 *
 * @author Eric Kubenka
 */
public class ExamplePage extends Page {

    @Check
    private GuiElement moreInformationLink = new GuiElement(this.getWebDriver(), By.partialLinkText("More information"));

    public ExamplePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMoreInformation() {
        moreInformationLink.click();
    }
}
