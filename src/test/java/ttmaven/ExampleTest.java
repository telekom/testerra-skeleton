/*
 * Created on 17.02.2020
 *
 * Copyright(c) 1995 - 2007 T-Systems Multimedia Solutions GmbH
 * Riesaer Str. 5, 01129 Dresden
 * All rights reserved.
 */
package ttmaven;

import eu.tsystems.mms.tic.testframework.pageobjects.factory.PageFactory;
import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import eu.tsystems.mms.tic.testframework.utils.ProxyUtils;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverManager;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverManagerUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * Sample Description goes here.
 * <p>
 * Date: 17.02.2020
 * Time: 12:42
 *
 * @author Eric Kubenka
 */
public class ExampleTest extends TesterraTest {

    @BeforeSuite
    public void proxySetup() {

        URL proxyUrl = ProxyUtils.getSystemHttpProxyUrl();

        if (proxyUrl != null) {
            DesiredCapabilities dc = new DesiredCapabilities();
            WebDriverManagerUtils.addProxyToCapabilities(dc, proxyUrl.toString());
            WebDriverManager.setGlobalExtraCapabilities(dc);
        }
    }

    @Test
    public void testT01_My_first_test() {
        WebDriver driver = WebDriverManager.getWebDriver();
        ExamplePage examplePage = PageFactory.create(ExamplePage.class, driver);
        examplePage.clickOnMoreInformation();
    }

}
