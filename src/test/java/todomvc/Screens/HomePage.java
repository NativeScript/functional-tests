package todomvc.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.exceptions.AppiumException;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    private UIElement btnAdd() {
        return this.find.byText("Add");
    }

    public UIElement btnComplete() {
        return this.find.byText("Complete!");
    }

    public UIElement btnUndoComplete() {
        return this.find.byText("Undo complete");
    }

    public UIElement btnEdit() {
        return this.find.byText("Edit");
    }

    private UIElement btnDelete() {
        return this.find.byText("Delete");
    }

    public UIElement btnDone() {
        return this.find.byText("Done");
    }

    public UIElement itemOne() {
        return this.find.byText("item 1");
    }

    public UIElement itemTwo() {
        return this.find.byText("item 2");
    }

    public UIElement newTask() {
        return this.wait.waitForVisible(this.locators.byText("new task", false, false), 3, true);
    }

    public List<UIElement> newTasks() {
        return this.find.elementsByLocator(this.locators.findByTextLocator("new task", true), 10);
    }

    public UIElement testTask() {
        return this.find.byText("test");

    }

    private List<UIElement> checkBoxes() {
        return this.find.elementsByLocator(this.locators.imageLocator());
    }

    public void tapAddBtn() {
        this.btnAdd().tap();
        this.log.info("Tap on \"Add\" button.");
    }

    public void tapCompleteBtn() {
        this.btnComplete().tap();
        this.log.info("Tap on \"Complete\" button.");
    }

    public void tapUndoCompleteBtn() {
        this.btnUndoComplete().tap();
        this.log.info("Tap on \"Undo complete\" button.");
    }

    public void tapEditBtn() {
        this.btnEdit().tap();
        this.log.info("Tap on \"Edit\" button.");
    }

    public void tapDeleteBtn() {
        this.btnDelete().tap();
        this.log.info("Tap on \"Delete\" button.");
    }

    public void tapDoneBtn() {
        this.btnDone().tap();
        this.log.info("Tap on \"Done\" button.");
    }

    public void tapNewTask() {
        this.newTask().tap();
        this.log.info("Tap on \"new task\" field.");
    }

    public void tapTestTask() {
        this.testTask().tap();
        this.log.info("Tap on \"test task\" field.");
    }

    public void tapCheckBox(int index) {
        this.checkBoxes().get(index).tap();
        this.log.info("Tap on \"CheckBox[" + index + "]\".");
    }

    public void loaded() throws AppiumException {
        if (this.btnAdd() != null) {
            this.log.info("TodoMVC app home page loaded.");
        } else {
            Assert.fail("TodoMVC app home page not loaded.");
        }
    }
}
