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
package com.telekom.mms.testerra.demo.page.theinternet.partials;

import eu.tsystems.mms.tic.testframework.pageobjects.AbstractComponent;
import eu.tsystems.mms.tic.testframework.pageobjects.Check;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import org.openqa.selenium.By;

/**
 * Describe footer, etc.
 * <p>
 * Date: 14.05.2020
 * Time: 12:53
 *
 * @author Eric Kubenka
 */
public class FooterPartialPage extends AbstractComponent<FooterPartialPage> {

    @Check
    private UiElement linkElementalSelenium = find(By.linkText("Elemental Selenium"));

    public FooterPartialPage(UiElement rootElement) {
        super(rootElement);
    }
}
