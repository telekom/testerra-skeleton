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
package eu.tsystems.mms.testerra.demo.tests;

import eu.tsystems.mms.testerra.demo.model.theinternet.UserModel;
import eu.tsystems.mms.testerra.demo.model.theinternet.UserModelFactory;
import eu.tsystems.mms.testerra.demo.page.theinternet.AddAndRemoveElementsPage;
import eu.tsystems.mms.testerra.demo.page.theinternet.DragAndDropPage;
import eu.tsystems.mms.testerra.demo.page.theinternet.StartPage;
import eu.tsystems.mms.testerra.demo.page.theinternet.TablePage;
import eu.tsystems.mms.tic.testframework.annotations.Fails;
import eu.tsystems.mms.tic.testframework.constants.Browsers;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementList;
import eu.tsystems.mms.tic.testframework.report.FailureCorridor;
import eu.tsystems.mms.tic.testframework.report.model.steps.TestStep;
import eu.tsystems.mms.tic.testframework.testing.PageFactoryProvider;
import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import eu.tsystems.mms.tic.testframework.testing.WebDriverManagerProvider;
import eu.tsystems.mms.tic.testframework.useragents.ChromeConfig;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Sample Description goes here.
 * <p>
 * Date: 17.02.2020
 * Time: 12:42
 *
 * @author Eric Kubenka
 */
public class TheInternetTest extends TesterraTest implements WebDriverManagerProvider, PageFactoryProvider {

    private static final UserModelFactory userModelFactory = new UserModelFactory();

    /**
     * https://tapas-docs.s3.eu-central-1.amazonaws.com/testerra/latest/index.html#_chrome_in_a_container
     */
    @BeforeSuite
    public void configureChromeOptions() {
        WEB_DRIVER_MANAGER.setUserAgentConfig(Browsers.chromeHeadless, new ChromeConfig() {
            @Override
            public void configure(ChromeOptions options) {
                options.addArguments("--disable-dev-shm-usage");
            }
        });
    }

    @Test
    public void testT01_DoDragAndDrop() {

        StartPage startPage = PAGE_FACTORY.createPage(StartPage.class);
        DragAndDropPage dragAndDropPage = startPage.goToDragAndDropPage();

        dragAndDropPage.getColumnA().expect().text("A");
        dragAndDropPage.getColumnB().expect().text("B");

        dragAndDropPage.doDragAndDrop();

        dragAndDropPage.getColumnA().expect().text("B");
        dragAndDropPage.getColumnB().expect().text("A");
    }

    @Test
    public void testT02_AddElementsTest() {

        StartPage startPage = PAGE_FACTORY.createPage(StartPage.class);

        AddAndRemoveElementsPage addAndRemoveElementsPage = startPage.goToAddAndRemoveElementsPage();
        addAndRemoveElementsPage.getDeleteElementButton().expect().foundElements().is(0);
        addAndRemoveElementsPage = addAndRemoveElementsPage.doAddElement();

        addAndRemoveElementsPage.getDeleteElementButton().expect().foundElements().is(1);
        addAndRemoveElementsPage = addAndRemoveElementsPage.doAddElement();

        addAndRemoveElementsPage.getDeleteElementButton().expect().foundElements().is(2);
        addAndRemoveElementsPage = addAndRemoveElementsPage.doAddElement();

        addAndRemoveElementsPage.getDeleteElementButton().expect().foundElements().is(3);
        addAndRemoveElementsPage = addAndRemoveElementsPage.doRemoveElement();

        addAndRemoveElementsPage.getDeleteElementButton().expect().foundElements().is(2);
    }

    @Test
    public void testT03_SortTables() {

        final UserModel userJohnSmith = userModelFactory.createJohnSmith();
        final UserModel userNonExisting = userModelFactory.createNonExisting();

        TestStep.begin("1. Init driver");
        StartPage startPage = PAGE_FACTORY.createPage(StartPage.class);

        TestStep.begin("2. Navigate to tables");
        TablePage tablePage = startPage.goToTablePage();

        TestStep.begin("3. Assert Last Name column present");
        UiElementList<TablePage.Row> rows = tablePage.getRows();
        TablePage.Row headerRow = rows.first();
        Assert.assertTrue(headerRow.getColumnNames().contains("Last Name"));

        TestStep.begin("4. Get data of first entry");
        TablePage.Row firstRow = rows.get(1);
        String lastNameBeforeSorting = firstRow.getColumnByName("Last Name").waitFor().text().getActual();

        TestStep.begin("5. Sort by Last Name");
        headerRow.getColumnByName("Last Name").click();

        TestStep.begin("6. Assert another data set is now in row 1");
        firstRow.getColumnByName("Last Name").expect().text().isNot(lastNameBeforeSorting);

        TestStep.begin("7. Assert user model shown");
        Assert.assertTrue(tablePage.isUserShown(userJohnSmith));
        Assert.assertFalse(tablePage.isUserShown(userNonExisting));
    }

    @Test
    @Fails(ticketString = "http://jira.mms/JIRA-1337", description = "Will fail because user does not exist")
    @FailureCorridor.Low
    public void testT04_TableEntryNotPresent() {

        final UserModel userNonExisting = userModelFactory.createNonExisting();
        TestStep.begin("1. Init driver");

        StartPage startPage = PAGE_FACTORY.createPage(StartPage.class);

        TestStep.begin("2. Navigate to tables");
        TablePage tablePage = startPage.goToTablePage();

        TestStep.begin("3. Assert user shown.");
        Assert.assertTrue(tablePage.isUserShown(userNonExisting));
    }

}
