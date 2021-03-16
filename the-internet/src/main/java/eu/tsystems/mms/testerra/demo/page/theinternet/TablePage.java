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
import eu.tsystems.mms.tic.testframework.pageobjects.AbstractComponent;
import eu.tsystems.mms.tic.testframework.pageobjects.Check;
import eu.tsystems.mms.tic.testframework.pageobjects.Page;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementList;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

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

    public static class Row extends AbstractComponent<Row> {
        private final UiElement table;
        private final UiElement headers;

        public Row(UiElement rootElement) {
            super(rootElement);
            this.table = (UiElement) rootElement.getParent();
            this.headers = table.find(By.className("header"));
        }

        private UiElement getColumnByPosition(int position) {
            return find(By.xpath(String.format("(./td|./th)[%d]", position)));
        }

        public UiElement getColumnByName(String columnName) {
            return getColumnByPosition(getColumnPosition(columnName));
        }

        public int getColumnPosition(final String column) {
            return getColumnNames().indexOf(column)+1;
        }

        public List<String> getColumnNames() {

            if (headers.waitFor().present(true)) {
                return headers.list().stream().map(uiElement -> uiElement.waitFor().text().getActual()).collect(Collectors.toList());
            }
            return List.of();
        }

    }

    @Check
    private UiElement tableOne = find(By.id("table1"));

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public TablePage doSortTableByColumn(String columnHeaderValue) {
        getRows().first().getColumnByName(columnHeaderValue).click();
        return createPage(TablePage.class);
    }

    public UiElementList<Row> getRows() {
        return createComponent(Row.class, tableOne.find(By.tagName("tr"))).list();
    }

    public boolean isUserShown(UserModel user) {

        Row first = getRows().first();
        int indexLastName = first.getColumnPosition("Last Name");
        int indexFirstName = first.getColumnPosition("First Name");
        final UiElement filteredDataRow = tableOne.find(
                By.xpath(".//tr" +
                        "//td[" + indexLastName + "][text()='" + user.getLastName() + "']/.." +
                        "//td[" + indexFirstName + "][text()='" + user.getFirstName() + "']/..")
        );

        return filteredDataRow.waitFor().displayed(true);
    }
}
