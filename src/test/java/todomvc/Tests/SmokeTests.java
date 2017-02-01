package todomvc.Tests;

import functional.tests.core.enums.PlatformType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTests extends TodoMvcBaseTest {

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
        this.homePage.tapEditBtn();
        this.homePage.newTask().setText(testTask);
        this.homePage.tapDoneBtn();
        this.hideKeyBoard();
        this.homePage.testTask();
    }

    @Test(groups = {"android", "ios"})
    public void todomvc_04_deleteTask() throws Exception {
        this.homePage.loaded();
        this.homePage.tapAddBtn();
        this.homePage.tapNewTask();
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

        this.homePage.tapCheckBox(3);
        this.homePage.btnUndoComplete();
    }

    @Test(groups = {"android", "ios"})
    public void todomvc_06_uncheckTask() throws Exception {
        this.homePage.loaded();
        this.homePage.btnUndoComplete();

        this.homePage.tapCheckBox(3);
        this.homePage.btnComplete();
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
        this.homePage.testTask();
        count = this.homePage.newTasks().size();
        Assert.assertEquals(count, 3);
        this.app.runInBackground(5);

        this.homePage.loaded();
        this.homePage.itemOne();
        this.homePage.itemTwo();
        this.homePage.testTask();
        count = this.homePage.newTasks().size();
        Assert.assertEquals(count, 3);
    }

    @Test(groups = {"android"})
    public void todomvc_09_restart() throws Exception {
        this.homePage.loaded();
        this.app.restart();
        this.homePage.loaded();
        this.homePage.itemOne();
        this.homePage.itemTwo();

        count = this.homePage.newTasks().size();
        Assert.assertEquals(count, 0);
    }

    // This is a work around for fix https://github.com/NativeScript/NativeScript/commit/25a7f131b26543bae9b725757b9290fa6dfa084c
    private void hideKeyBoard() {
        if (this.settings.platformVersion <= 5.1 && this.settings.platform == PlatformType.Andorid) {
            this.homePage.hideKeyboard();
        }
    }
}