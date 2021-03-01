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

    private FooterPartialPage footer = PageFactory.create(FooterPartialPage.class, this.getWebDriver());

    @Check
    private GuiElement tableOne = new GuiElement(this.getWebDriver(), By.id("table1"));
    private GuiElement tableOneHeader = tableOne.getSubElement(By.className("header"));

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getAvailAbleColumnNames() {

        final List<String> columnNames = new LinkedList<>();

        if (tableOneHeader.isPresent()) {
            tableOneHeader.getList().forEach(headerElement -> columnNames.add(headerElement.getText()));
        }

        return columnNames;
    }

    public TablePage doSortTableByColumn(String columnHeaderValue) {

        final Optional<GuiElement> headerElementToSort = tableOneHeader.getList().stream().filter(headerElement -> headerElement.getText().equals(columnHeaderValue)).findAny();
        headerElementToSort.ifPresent(GuiElement::click);
        return PageFactory.create(TablePage.class, this.getWebDriver());
    }

    public HashMap<String, String> getRowDataByIndex(int row) {

        final HashMap<String, String> result = new HashMap<>();

        final List<String> availAbleColumnNames = this.getAvailAbleColumnNames();
        final GuiElement tableRow = this.getTableRows().get(row);

        for (int i = 0; i < availAbleColumnNames.size(); i++) {
            final GuiElement tdElement = tableRow.getSubElement(By.cssSelector("td")).getList().get(i);
            result.put(availAbleColumnNames.get(i), tdElement.getText());
        }

        return result;
    }

    public boolean isUserShown(UserModel user) {

        int indexLastName = getIndexOfColumn("Last Name");
        int indexFirstName = getIndexOfColumn("First Name");
        final GuiElement filteredDataRow = tableOne.getSubElement(
                By.xpath(".//tr" +
                        "//td[" + indexLastName + "][text()='" + user.getLastName() + "']/.." +
                        "//td[" + indexFirstName + "][text()='" + user.getFirstName() + "']/..")
        );

        return filteredDataRow.isDisplayed();
    }

    private List<GuiElement> getTableRows() {

        return tableOne.getSubElement(By.xpath(".//tr")).getList();
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
