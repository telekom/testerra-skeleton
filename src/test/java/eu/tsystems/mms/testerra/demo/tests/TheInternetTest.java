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
import eu.tsystems.mms.tic.testframework.pageobjects.factory.PageFactory;
import eu.tsystems.mms.tic.testframework.report.FailureCorridor;
import eu.tsystems.mms.tic.testframework.report.model.steps.TestStep;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import eu.tsystems.mms.testerra.demo.AbstractTest;

import java.util.HashMap;
import java.util.List;

/**
 * Sample Description goes here.
 * <p>
 * Date: 17.02.2020
 * Time: 12:42
 *
 * @author Eric Kubenka
 */
public class TheInternetTest extends AbstractTest {

    private static final UserModelFactory userModelFactory = new UserModelFactory();

    @Test
    public void testT01_DoDragAndDrop() {

        final WebDriver driver = WebDriverManager.getWebDriver();
        StartPage startPage = PageFactory.create(StartPage.class, driver);
        DragAndDropPage dragAndDropPage = startPage.goToDragAndDropPage();

        Assert.assertEquals(dragAndDropPage.getColumnAText(), "A");
        Assert.assertEquals(dragAndDropPage.getColumnBText(), "B");

        dragAndDropPage.doDragAndDrop();

        Assert.assertEquals(dragAndDropPage.getColumnAText(), "B");
        Assert.assertEquals(dragAndDropPage.getColumnBText(), "A");

    }

    @Test
    public void testT02_AddElementsTest() {

        final WebDriver driver = WebDriverManager.getWebDriver();
        StartPage startPage = PageFactory.create(StartPage.class, driver);

        AddAndRemoveElementsPage addAndRemoveElementsPage = startPage.goToAddAndRemoveElementsPage();

        Assert.assertEquals(addAndRemoveElementsPage.getElementCount(), 0);
        addAndRemoveElementsPage = addAndRemoveElementsPage.doAddElement();

        Assert.assertEquals(addAndRemoveElementsPage.getElementCount(), 1);
        addAndRemoveElementsPage = addAndRemoveElementsPage.doAddElement();

        Assert.assertEquals(addAndRemoveElementsPage.getElementCount(), 2);
        addAndRemoveElementsPage = addAndRemoveElementsPage.doAddElement();

        Assert.assertEquals(addAndRemoveElementsPage.getElementCount(), 3);
        addAndRemoveElementsPage = addAndRemoveElementsPage.doRemoveElement();

        Assert.assertEquals(addAndRemoveElementsPage.getElementCount(), 2);
    }

    @Test
    public void testT03_SortTables() {

        final UserModel userJohnSmith = userModelFactory.createJohnSmith();
        final UserModel userNonExisting = userModelFactory.createNonExisting();

        TestStep.begin("1. Init driver");
        final WebDriver driver = WebDriverManager.getWebDriver();
        StartPage startPage = PageFactory.create(StartPage.class, driver);

        TestStep.begin("2. Navigate to tables");
        TablePage tablePage = startPage.goToTablePage();

        TestStep.begin("3. Assert Last Name column present");
        final List<String> availAbleColumnNames = tablePage.getAvailAbleColumnNames();
        Assert.assertTrue(availAbleColumnNames.contains("Last Name"));

        TestStep.begin("4. Get data of first entry");
        HashMap<String, String> row1BeforeSorting = tablePage.getRowDataByIndex(1);

        TestStep.begin("5. Sort by Last Name");
        tablePage = tablePage.doSortTableByColumn("Last Name");

        TestStep.begin("6. Assert another data set is now in row 1");
        HashMap<String, String> row1AfterSorting = tablePage.getRowDataByIndex(1);
        Assert.assertNotEquals(row1AfterSorting.get("Last Name"), row1BeforeSorting.get("Last Name"));

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

        final WebDriver driver = WebDriverManager.getWebDriver();
        StartPage startPage = PageFactory.create(StartPage.class, driver);

        TestStep.begin("2. Navigate to tables");
        TablePage tablePage = startPage.goToTablePage();

        TestStep.begin("3. Assert user shown.");
        Assert.assertTrue(tablePage.isUserShown(userNonExisting));
    }

}
