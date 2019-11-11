package uitests.Screens.Dialogs;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class DialogsPage extends HomePageExtended {

    public static final String name1 = "John Reese";

    public DialogsPage(String example, MobileContext context) {
        super(example, context);
        this.basePageLoaded();
    }

    public UIElement label() {
        this.wait.waitForVisible(this.locators.labelLocator(), 6, true);
        if (this.settings.platform == PlatformType.Android) {
            return this.find.elementsByLocator(this.locators.labelLocator()).get(1);
        } else if (this.settings.platform == PlatformType.iOS) {
            if (this.settings.deviceName.contains("X")) {
                if (this.settings.platformVersion < 13) {
                    return this.find.elementsByLocator(this.locators.labelLocator()).get(1);
                } else {
                    return this.find.elementsByLocator(this.locators.labelLocator()).get(0);
                }
            } else {
                if (this.settings.platformVersion < 11) {
                    return this.find.byLocator(By.xpath("//XCUIElementTypeStaticText"));
                } else {
                    return this.find.byLocator(this.locators.labelLocator());
                }
            }
        } else {
            return null;
        }
    }

    public String getLabelText() {
        return this.label().getText();
    }

    public void tapActionBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("action")).click();
        } else {
            this.find.byText("action").click();
        }
    }

    public void tapAlertBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("alert")).click();
        } else {
            this.find.byText("alert").click();
        }
    }

    public void tapConfirmBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("confirm")).click();
        } else {
            this.find.byText("confirm").click();
        }
    }

    public void tapLoginBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("login")).click();
        } else {
            this.find.byText("login").click();
        }
        this.log.info("Tap on 'login' button.");
    }

    public void tapPromptTextBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("promptText")).click();
        } else {
            this.find.byText("promptText").click();
        }
    }

    public void tapPromptPassBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("promptPass")).click();
        } else {
            this.find.byText("promptPass").click();
        }
    }

    public void tapPromptEmailBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("promptEmail")).click();
        } else {
            this.find.byText("promptEmail").click();
        }
    }

    public void tapPromptDecimalBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("promptDecimal")).click();
        } else {
            this.find.byText("promptDecimal").click();
        }
    }

    public void tapOkBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("OK")).tap();
        } else {
            this.find.byText("OK").tap();
        }
    }

    public void tapCloseBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("Close")).tap();
        } else {
            this.find.byText("Close").tap();
        }
    }

    public void tapCancelBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.AccessibilityId("Cancel")).click();
        } else {
            this.find.byText("Cancel").click();
        }
    }

    public void tapIgnoreBtn() {
        this.find.byText("Ignore").click();
    }

    public void tapYesBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.name("Yes")).tap();
        } else {
            this.find.byText("Yes").click();
        }
        this.log.info("Choose 'Yes' option.");
    }

    public void tapNoBtn() {
        if (this.settings.platform == PlatformType.iOS) {
            this.find.byLocator(MobileBy.name("No")).tap();
        } else {
            this.find.byText("No").click();
        }
        this.log.info("Choose 'No' option.");
    }

    private void basePageLoaded() {
        if (this.label() != null) {
            this.log.info("Modals page loaded.");
        } else {
            Assert.fail("Modals page NOT loaded.");
        }
    }
}
