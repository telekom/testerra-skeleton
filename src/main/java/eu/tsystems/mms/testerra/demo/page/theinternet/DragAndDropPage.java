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

import eu.tsystems.mms.testerra.demo.page.theinternet.partials.FooterPartialPage;
import eu.tsystems.mms.tic.testframework.pageobjects.Check;
import eu.tsystems.mms.tic.testframework.pageobjects.GuiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.Locate;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import eu.tsystems.mms.tic.testframework.pageobjects.factory.PageFactory;
import eu.tsystems.mms.tic.testframework.utils.MouseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represtents https://the-internet.herokuapp.com/drag_and_drop
 * <p>
 * Date: 14.05.2020
 * Time: 12:58
 *
 * @author Eric Kubenka
 */
public class DragAndDropPage extends Page {

    private FooterPartialPage footer = PageFactory.create(FooterPartialPage.class, this.getWebDriver());

    @Check
    private GuiElement columnAWrapper = new GuiElement(this.getWebDriver(), By.id("column-a"));
    @Check
    private GuiElement columnBWrapper = new GuiElement(this.getWebDriver(), By.id("column-b"));

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage doDragAndDrop() {
        MouseActions.dragAndDropJS(columnAWrapper, columnBWrapper);
        return this;
    }

    public String getColumnAText() {
        return this.columnAWrapper.getText();
    }

    public String getColumnBText() {

        return this.columnBWrapper.getText();
    }
}
