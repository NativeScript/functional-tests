package todomvc.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTestsiOS extends TodoMvcBaseTest {

    @Test(groups = {"android", "ios"})
    public void todomvc_00_addTask() throws Exception {
        this.homePage.tapAddBtn();
        this.homePage.itemOne();
        this.homePage.itemTwo();
        this.homePage.newTask();
        this.log.logScreen(this.context.getTestName(), this.context.getTestName(), 320, 240);
    }

    @Test(groups = {"android", "ios"})
    public void todomvc_01_completeTask() throws Exception {
        this.homePage.loaded();
        this.homePage.tapNewTask();
        this.homePage.tapCompleteBtn();
        this.homePage.btnUndoComplete();
    }

    @Test(groups = {"android", "ios"})
    public void todomvc_02_undoCompleteTask() throws Exception {
        this.homePage.loaded();
        this.homePage.tapUndoCompleteBtn();
        this.homePage.btnComplete();
    }

    @Test(groups = {"android", "ios"})
    public void todomvc_03_editTask() throws Exception {
        this.homePage.loaded();
        this.homePage.btnEdit();
    }

    @Test(groups = {"android", "ios"})
    public void todomvc_04_deleteTask() throws Exception {
        this.homePage.loaded();
        this.homePage.tapDeleteBtn();

        count = this.homePage.newTasks().size();
        Assert.assertEquals(count, 0);
    }

    @Test(groups = {"android", "ios"})
    public void todomvc_05_checkTask() throws Exception {
        this.homePage.loaded();
        this.homePage.tapAddBtn();
        this.homePage.tapNewTask();
        this.homePage.btnComplete();
        this.homePage.tapCheckBox(2);
    }

    @Test(groups = {"android", "ios"})
    public void todomvc_06_uncheckTask() throws Exception {
        this.homePage.loaded();
        this.homePage.tapNewTask();
        this.homePage.btnUndoComplete();
        this.homePage.tapCheckBox(2);
    }

    @Test(groups = {"android", "ios"})
    public void todomvc_07_addMultipleTasks() throws Exception {
        this.homePage.loaded();
        this.homePage.tapAddBtn();
        this.homePage.tapAddBtn();

        count = this.homePage.newTasks().size();
        Assert.assertEquals(count, 3);
        this.log.logScreen(this.context.getTestName(), this.context.getTestName(), 320, 240);
    }

    @Test(groups = {"android", "ios"})
    public void todomvc_08_runInBackground() throws Exception {
        this.homePage.loaded();
        this.app.runInBackground(5);

        this.homePage.loaded();
        this.homePage.itemOne();
        this.homePage.itemTwo();
        count = this.homePage.newTasks().size();
        Assert.assertEquals(count, 3);
        this.app.runInBackground(5);

        this.homePage.loaded();
        this.homePage.itemOne();
        this.homePage.itemTwo();
        count = this.homePage.newTasks().size();
        Assert.assertEquals(count, 3);
    }
}