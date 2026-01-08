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
package com.telekom.mms.testerra.demo.page.theinternet;

import com.telekom.mms.testerra.demo.page.theinternet.partials.FooterPartialPage;
import eu.tsystems.mms.tic.testframework.pageobjects.Check;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Sample start page of the-internet.herokuapp.com
 * <p>
 * Date: 14.05.2020
 * Time: 12:51
 *
 * @author Eric Kubenka
 */
public class StartPage extends Page {

    private FooterPartialPage footer = createComponent(FooterPartialPage.class, find(By.id("page-footer")));

    @Check
    private UiElement headerElement = find(By.cssSelector("h1.heading"));

    @Check
    private UiElement navLinkDragAndDrop = find(By.linkText("Drag and Drop"));

    @Check
    private UiElement navLinkAddAndRemoveElements = find(By.linkText("Add/Remove Elements"));
    @Check
    private UiElement navLinkTables = find(By.linkText("Sortable Data Tables"));

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage goToDragAndDropPage() {

        this.navLinkDragAndDrop.click();
        return createPage(DragAndDropPage.class);

    }

    public AddAndRemoveElementsPage goToAddAndRemoveElementsPage() {

        this.navLinkAddAndRemoveElements.click();
        return createPage(AddAndRemoveElementsPage.class);
    }

    public TablePage goToTablePage() {

        this.navLinkTables.click();
        return createPage(TablePage.class);
    }
}
