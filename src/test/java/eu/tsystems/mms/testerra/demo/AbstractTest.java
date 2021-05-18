package eu.tsystems.mms.testerra.demo;

import eu.tsystems.mms.tic.testframework.constants.Browsers;
import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import eu.tsystems.mms.tic.testframework.useragents.ChromeConfig;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverManager;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverProxyUtils;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.BeforeSuite;

public class AbstractTest extends TesterraTest {
    /**
     * https://tapas-docs.s3.eu-central-1.amazonaws.com/testerra/latest/index.html#_chrome_in_a_container
     */
    @BeforeSuite
    public void configureChromeOptions() {
        WebDriverManager.setUserAgentConfig(Browsers.chromeHeadless, new ChromeConfig() {
            @Override
            public void configure(ChromeOptions options) {
                options.addArguments("--disable-dev-shm-usage");
            }
        });
    }

    @BeforeSuite
    public void setupProxy() {
        Proxy proxy = new WebDriverProxyUtils().getDefaultHttpProxy();
        WebDriverManager.setGlobalExtraCapability(CapabilityType.PROXY, proxy);
    }
}
