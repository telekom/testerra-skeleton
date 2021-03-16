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

import eu.tsystems.mms.testerra.demo.model.theinternet.UserModel;
import eu.tsystems.mms.testerra.demo.page.theinternet.partials.FooterPartialPage;
import eu.tsystems.mms.tic.testframework.pageobjects.Check;
import eu.tsystems.mms.tic.testframework.pageobjects.GuiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.Locate;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementList;
import eu.tsystems.mms.tic.testframework.pageobjects.factory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Represents https://the-internet.herokuapp.com/tables
 * <p>
 * Date: 14.05.2020
 * Time: 12:58
 *
 * @author Eric Kubenka
 */
public class TablePage extends Page {

    private FooterPartialPage footer = createComponent(FooterPartialPage.class, find(By.id("page-footer")));

    @Check
    private UiElement tableOne = find(By.id("table1"));
    private UiElement tableOneHeader = tableOne.find(By.className("header"));

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getAvailAbleColumnNames() {

        final List<String> columnNames = new LinkedList<>();

        if (tableOneHeader.waitFor().present(true)) {
            tableOneHeader.list().forEach(headerElement -> columnNames.add(headerElement.waitFor().text().getActual()));
        }

        return columnNames;
    }

    public TablePage doSortTableByColumn(String columnHeaderValue) {

        final Optional<UiElement> headerElementToSort = tableOneHeader.list().stream().filter(headerElement -> headerElement.waitFor().text(columnHeaderValue)).findAny();
        headerElementToSort.ifPresent(UiElement::click);
        return createPage(TablePage.class);
    }

    public HashMap<String, String> getRowDataByIndex(int row) {

        final HashMap<String, String> result = new HashMap<>();

        final List<String> availAbleColumnNames = this.getAvailAbleColumnNames();
        final UiElement tableRow = this.getTableRows().get(row);

        for (int i = 0; i < availAbleColumnNames.size(); i++) {
            final UiElement tdElement = tableRow.find(By.cssSelector("td")).list().get(i);
            result.put(availAbleColumnNames.get(i), tdElement.waitFor().text().getActual());
        }

        return result;
    }

    public boolean isUserShown(UserModel user) {

        int indexLastName = getIndexOfColumn("Last Name");
        int indexFirstName = getIndexOfColumn("First Name");
        final UiElement filteredDataRow = tableOne.find(
                By.xpath(".//tr" +
                        "//td[" + indexLastName + "][text()='" + user.getLastName() + "']/.." +
                        "//td[" + indexFirstName + "][text()='" + user.getFirstName() + "']/..")
        );

        return filteredDataRow.waitFor().displayed(true);
    }

    private UiElementList<UiElement> getTableRows() {
        return tableOne.find(By.xpath(".//tr")).list();
    }

    private int getIndexOfColumn(final String column) {

        final List<String> availAbleColumnNames = this.getAvailAbleColumnNames();
        for (int i = 0; i < availAbleColumnNames.size(); i++) {
            if (availAbleColumnNames.get(i).equals(column)) {
                return i + 1;
            }
        }

        return 0;
    }
}
