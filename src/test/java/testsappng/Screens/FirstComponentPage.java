package testsappng.Screens;

import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import functional.tests.core.helpers.NavigationManager;
import org.testng.Assert;

public class FirstComponentPage extends HomePage {
    public static String backString = "Back";
    public static String firstComponentString = "First component";
    public static String secondComponentString = "Second";
    public static String bntGoToSecond = "GO TO SECOND";

    public FirstComponentPage(Context context) {
        this("", context);
    }

    public FirstComponentPage(Context context, NavigationManager navigationManager) {
        super(context, navigationManager);
    }

    public FirstComponentPage(String mainPage, Context context) {
        super(mainPage, context);
    }

    private UIElement label() {
        return this.find.byText(firstComponentString);
    }

    private UIElement btnBack() {
        return this.find.byText(backString);
    }

    private UIElement btnSecond() {
        return this.find.byText(secondComponentString);
    }

    private UIElement btnGoToSecond() {
        return this.find.byText(bntGoToSecond);
    }

    public void tapBackBtn() {
        this.btnBack().click();
        this.log.info("Tap on 'Back' button.");
    }

    public SecondComponentPage tapSecondBtn() {
        this.btnSecond().click();
        this.log.info("Tap on 'Second' button.");

        return new SecondComponentPage(this.context);
    }

    public SecondComponentPage tapGoToSecondBtn() {
        this.btnGoToSecond().click();
        this.log.info("Tap on 'GO TO SECOND' button.");

        return new SecondComponentPage(this.context);
    }

    public void loadedFirstComponentPage() {
        if (this.label() != null) {
            this.log.info("First Component homePageLoaded.");
        } else {
            Assert.fail("First Component NOT homePageLoaded.");
        }
    }
}
