package uitests.Tests.Component;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.element.UIRectangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.Components.ActionBarPage;


public class ActionBarTests extends MobileTest {
    private ActionBarPage actionBarPage;

    private void verifyElement(UIElement element) {
        try {
            this.compareElements(element, 5, 1.5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClassActionBarTests() {
        this.actionBarPage = new ActionBarPage(this.context);
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_01() throws Exception {
        this.actionBarPage.navigateTo("actStyle");
        this.verifyElement(this.actionBarPage.actionBar());

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_02_clean() throws Exception {
        this.actionBarPage.tapActionItem();
        this.verifyElement(this.actionBarPage.actionBar());

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_03() throws Exception {
        this.actionBarPage.tapActionItem();
        this.compareElements("actionBar_01", this.actionBarPage.actionBar(), 5, 1.5);

        this.actionBarPage.navigateToMainPage();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_11_systemIcons() throws Exception {
        this.actionBarPage.navigateTo("actIcons");
        this.actionBarPage.loaded();
        this.verifyElement(this.actionBarPage.actionBar());

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_12_systemIcons_clean() throws Exception {
        this.actionBarPage.tapGoToCleanPageBtn();
        this.compareElements("actionBar_02_clean", this.actionBarPage.actionBar(), 10, 1.5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_13_systemIcons() throws Exception {
        this.actionBarPage.tapGoToPreviousPageBtn();
        this.compareElements("actionBar_11_systemIcons", this.actionBarPage.actionBar(), 10, 0.01);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_21_actionView() throws Exception {
        this.actionBarPage.navigateTo("actView");

        if (this.settings.automationName == "UIAutomator2") {
            this.compareScreens(3);
        } else {
            this.verifyElement(this.actionBarPage.actionBar());
        }
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_22_actionView_clean() throws Exception {
        this.actionBarPage.navigateTo(this.actionBarPage.greenActionView());
        this.compareElements("actionBar_02_clean", this.actionBarPage.actionBar(), 10, 1.5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_23_actionView() throws Exception {
        this.actionBarPage.navigateBack();

        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion >= 7) {
            this.compareScreens("actionBar_21_actionView", 10, 1.5);
        } else {
            this.compareElements("actionBar_21_actionView", this.actionBarPage.actionBar(), 10, 1.5);
        }

        this.assertImagesResults();
        this.actionBarPage.navigateToMainPage();
    }

    @Test(groups = {"ios"})
    public void actionBar_3_actionItemPosition() throws Exception {
        this.actionBarPage.navigateTo("actionItemPosition");
        this.compareScreens(5);

        this.actionBarPage.tapOnBtnTap();
        this.compareScreens(5);

        this.actionBarPage.tapOnBtnTap();
        this.compareScreens(5);

        this.actionBarPage.tapOnBtnTap();
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_41_actBGCss_issue_516() throws Exception {
        this.actionBarPage.navigateTo("actBGCss");
        String imageNameRed = "actionBar_41_actBGCss_red";
        String imageNameTrans = "actionBar_41_actBGCss_trans";
        this.compareElements(imageNameRed, this.actionBarPage.actionBar(), 10, 0.01);
        UIRectangle btnGoTo = new UIRectangle(this.find.byTextContains("go to").getUIRectangle());
        btnGoTo.tap();
        this.compareElements(imageNameTrans, this.actionBarPage.actionBar(), 10, 0.01);
        btnGoTo.tap();
        this.compareElements(imageNameRed, this.actionBarPage.actionBar(), 10, 0.01);
        btnGoTo.tap();
        this.find.byTextContains("ITEM").tap();
        this.compareElements(imageNameRed, this.actionBarPage.actionBar(), 10, 0.01);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_Background() throws Exception {
        this.actionBarPage.navigateTo("actBG");
        this.compareScreens(10);
        UIElement btnGoTo = this.find.byTextContains("go to");
        UIRectangle btnGoToRect = new UIRectangle(btnGoTo.getUIRectangle());
        btnGoToRect.tap();
        this.compareScreens(10);
        btnGoToRect.tap();
        this.compareScreens(10);
        this.actionBarPage.navigateTo(this.find.byTextContains("go to"));

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void actionBar_transparentBackGround_3570() throws Exception {
        this.actionBarPage.navigateTo("actTransparentBgCss");
        this.compareScreens(3);
        this.actionBarPage.find.byText("go to cleared page").tap();
        this.compareScreens(3);
        this.actionBarPage.tapActionItem();
        this.compareScreens(3);

        this.assertImagesResults();
    }
}
