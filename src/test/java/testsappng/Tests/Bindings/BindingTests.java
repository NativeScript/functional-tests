package testsappng.Tests.Bindings;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.BindingPage;
import testsappng.TestsAppNgBase;

public class BindingTests extends TestsAppNgBase {
    protected BindingPage bindingPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClassBindingTests() throws Exception {
        this.bindingPage = new BindingPage("Binding", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void binding_01() throws Exception {
        this.bindingPage.insertNewValues();
        this.bindingPage.getResults();
        Assert.assertTrue(this.bindingPage.compareResults("1", "0", "5"), "Binding is not working");

        this.bindingPage.updateValuesFromCodeBehind();
        this.bindingPage.getResults();

        Assert.assertTrue(this.bindingPage.compareResults("0", "0", "0"), "Binding is not working from code behind!");
    }

}