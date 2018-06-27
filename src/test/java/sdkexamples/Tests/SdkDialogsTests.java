package sdkexamples.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkDialogsTests extends SdkBaseTest {

    protected String page = "Dialogs";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Action dialog", "Cancel"},
                {"Alert dialog", "OK"},
                {"Confirm dialog", "Cancel"},
                {"Login dialog", "Cancel"},
                {"Prompt dialog", "Cancel"}};
    }

    @Test(dataProvider = "example")
    public void sdkDialogsTest(String example, String btn) throws Exception {
        this.mainPage.navigateTo(example);
        String buttonTitle = "Display " + example.replace("dialog", "Dialog");
        this.mainPage.find.byText(buttonTitle).click();

        if (buttonTitle.equalsIgnoreCase("Login dialog")) {
            this.mainPage.find.byLocator(By.id("return")).click();
            this.mainPage.find.byLocator(By.id("return")).click();
        }
        if (buttonTitle.equalsIgnoreCase("Prompt dialog")) {
            this.mainPage.find.byLocator(By.id("return")).click();
        }

        // Close dialogs
        UIElement btnSubmitDialog = this.find.byTextContains(btn);
        btnSubmitDialog.tap();
    }
}
