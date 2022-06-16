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

package eu.tsystems.mms.testerra.demo.page.theinternet;

import eu.tsystems.mms.tic.testframework.l10n.SimpleLocalization;
import eu.tsystems.mms.tic.testframework.pageobjects.Check;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import eu.tsystems.mms.tic.testframework.pageobjects.TestableUiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents https://the-internet.herokuapp.com/add_remove_elements/
 * <p>
 * Date: 14.05.2020
 * Time: 13:16
 *
 * @author Eric Kubenka
 */
public class AddAndRemoveElementsPage extends Page {

    @Check
    private UiElement buttonAddElement = find(By.xpath("//button[text()='" + SimpleLocalization.getText("BUTTON_ADD_ELEMENT") + "']"));

    @Check
    private UiElement sectionElements = find(By.id("elements"));

    // No Check here, because on initial load, list is empty.
    private UiElement deleteElementButtonList = sectionElements.find(By.xpath("//button[text()='" + SimpleLocalization.getText("BUTTON_DELETE") + "']"));

    /**
     * Constructor for existing sessions.
     *
     * @param driver .
     */
    public AddAndRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks Button "Add element"
     *
     * @return New instance AddAndRemoveElementsPage
     */
    public AddAndRemoveElementsPage doAddElement() {

        this.buttonAddElement.click();
        return createPage(AddAndRemoveElementsPage.class);
    }

    public TestableUiElement getDeleteElementButton() {
        return this.deleteElementButtonList;
    }

    public AddAndRemoveElementsPage doRemoveElement() {

        if (this.deleteElementButtonList.waitFor().displayed(true)) {
            this.deleteElementButtonList.click();
        }

        return createPage(AddAndRemoveElementsPage.class);
    }
}
