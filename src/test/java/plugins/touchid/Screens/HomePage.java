package plugins.touchid.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(MobileContext context) {
        super(context);
    }

    private UIElement tabDemo() {
        return this.find.byLocator(By.id("Demo"));
    }

    private UIElement btnAvailable() {
        return this.find.byLocator(By.id("available?"));
    }

    public void tapDemoBtn() {
        this.tabDemo().click();
        this.log.info("Tap on 'Demo' tap.");
    }

    public void tapAvailableBtn() {
        this.btnAvailable().click();
        this.log.info("Tap on 'available' button.");
    }

    public void tapOkBtn() {
        this.find.byText("OK").click();
        this.log.info("Tap on 'Ok' button.");
    }

    public void loaded() {
        if (this.tabDemo() != null) {
            this.log.info("TouchID app loaded.");
        } else {
            Assert.fail("TouchID app NOT loaded.");
        }
    }
}
