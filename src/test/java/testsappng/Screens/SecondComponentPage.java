package testsappng.Screens;

import functional.tests.core.basepage.BasePageExtended;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class SecondComponentPage extends BasePageExtended {

    public static String secondComponentString = "Second component";
    public static String firstComponentString = "First";
    public static String bntGoToFirst = "GO TO FIRST";

    public SecondComponentPage(Context context) {
        super(context, context.navigationManager);
    }

    private UIElement label() {
        return this.find.byTextContains(secondComponentString);
    }

    private UIElement btnFirst() {
        return this.find.byText(firstComponentString);
    }

    private UIElement btnGoToFirst() {
        return this.find.byText(bntGoToFirst);
    }

    public FirstComponentPage tapFirstBtn() {
        this.btnFirst().click();
        this.log.info("Tap on 'First' button.");

        return new FirstComponentPage(this.context, this.context.navigationManager);
    }

    public FirstComponentPage tapGoToFirstBtn() {
        this.btnGoToFirst().click();
        this.log.info("Tap on 'GO TO FIRST' button.");

        return new FirstComponentPage(this.context, this.context.navigationManager);
    }

    public void loadedSecondComponentPage() {
        if (this.label() != null) {
            this.log.info("Second Component homePageLoaded.");
        } else {
            Assert.fail("Second Component NOT homePageLoaded.");
        }
    }

    public ActionBarFirstPage navigateBackToActionBarFirstPage() {
        this.navigateBack();

        return new ActionBarFirstPage(this.context, this.context.navigationManager);
    }
}
