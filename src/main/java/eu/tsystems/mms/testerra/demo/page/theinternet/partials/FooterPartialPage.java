/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Eric Kubenka
 */
package eu.tsystems.mms.testerra.demo.page.theinternet.partials;

import eu.tsystems.mms.tic.testframework.pageobjects.Check;
import eu.tsystems.mms.tic.testframework.pageobjects.GuiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Describe footer, etc.
 * <p>
 * Date: 14.05.2020
 * Time: 12:53
 *
 * @author Eric Kubenka
 */
public class FooterPartialPage extends Page {

    @Check
    private GuiElement sectionFooter = new GuiElement(this.getWebDriver(), By.id("page-footer"));

    @Check
    private GuiElement linkElementalSelenium = sectionFooter.getSubElement(By.linkText("Elemental Selenium"));

    public FooterPartialPage(WebDriver driver) {
        super(driver);
    }
}
