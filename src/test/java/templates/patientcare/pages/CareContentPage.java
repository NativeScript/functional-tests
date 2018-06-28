package templates.patientcare.pages;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class CareContentPage extends BasePage {

    private String androidTabItemLocator = "//android.widget.HorizontalScrollView//android.widget.TextView";

    public CareContentPage() {
        super();
        UIElement home = this.wait.waitForVisible(this.locators.findByTextLocator("Care Contents", true));
        Assert.assertNotNull(home, "Care Contents page not loaded!");
        this.log.info("Care Contents page loaded.");
    }


    public void openCareContent() {
        if (this.settings.platform == PlatformType.Android) {
            this.find.elementsByLocator(By.xpath(this.androidTabItemLocator)).get(0).click();
        } else {
            this.wait.waitForVisible(this.locators.byText("Care Contents")).click();
        }
        this.log.info("Click 'Care Contents' tab.");
    }

    public void openConnect() {
        if (this.settings.platform == PlatformType.Android) {
            this.find.elementsByLocator(By.xpath(this.androidTabItemLocator)).get(1).click();
        } else {
            this.wait.waitForVisible(this.locators.byText("Connect")).click();
        }
        this.log.info("Click 'Connect' tab.");
    }

    public String getCurrentTab() {
        if (this.settings.platform == PlatformType.Android) {
            List<UIElement> tabs = this.wait.forVisibleElements(By.xpath(this.androidTabItemLocator), this.settings.shortTimeout, true);

            if (tabs.get(0).isSelected()) {
                return tabs.get(0).getText();
            } else if (tabs.get(1).isSelected()) {
                return tabs.get(1).getText();
            } else {
                return null;
            }
        } else {
            By by = By.xpath("//XCUIElementTypeNavigationBar[@name='Care Contents']");
            UIElement careContents = this.wait.waitForVisible(by, this.settings.shortTimeout, false);
            if (careContents == null) {
                return "Connect";
            } else {
                return "Care Contents";
            }
        }
    }
}
