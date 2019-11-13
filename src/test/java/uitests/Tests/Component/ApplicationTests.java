package uitests.Tests.Component;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import io.appium.java_client.MobileBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitests.Screens.UITestsBasePage;

public class ApplicationTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void application_01_launch_resume() throws Exception {
        this.app.restart();
        Wait.sleep(3000);
        if (this.settings.platform == PlatformType.Android) {
            this.context.getDevice().assertLogContains("### Launched application with:");
            this.log.info("The log contains '### Launched application with:'");

            this.context.getDevice().assertLogContains("#1# ResumeEvent");
            this.log.info("The log contains '#1# ResumeEvent'");
        } else if (this.settings.platform == PlatformType.iOS && !this.settings.isRealDevice) {
            String iOSLog = this.context.getDevice().getIOSDevice().iosDeviceLog.getDeviceLogTail();

            Assert.assertTrue(iOSLog.contains("### Launched application with:"));
            this.log.info("The log contains '### Launched application with:'");

            Assert.assertTrue(iOSLog.contains("#1# ResumeEvent"));
            this.log.info("The log contains '#1# ResumeEvent'");
        }
    }

    @Test(groups = {"android", "ios"})
    public void application_02_suspend_resume() throws Exception {
        if (this.settings.platform == PlatformType.Android && this.settings.isRealDevice && this.settings.platformVersion == 4.3) {
            return;
        }

        this.log.info("Run the application in background.");
        this.app.runInBackground(2);
        this.wait.waitForVisible(this.locators.byText("Run"), 15, true);
        this.context.getDevice().assertLogContains("#1# SuspendEvent");
        if (this.settings.platform != PlatformType.iOS && !this.settings.platformVersion.toString().startsWith("9")) {
            this.device.assertLogContains("#2# ResumeEvent");
        }
    }

    @Test(groups = {"android", "ios"})
    public void tabview_with_scrollview_4022() throws Exception {
        UITestsBasePage basePage = new UITestsBasePage("issues", this.context);
        basePage.navigateTo("issues");
        basePage.navigateTo("tabview-with-scrollview_4022");
        findElement("Tab 2").click();
        this.log.info("Run the application in background.");
        this.app.runInBackground(5);
        findElement("Tab 1").click();
        findElement("Tab 2").click();
        findElement("Tab 3").click();

        this.assertScreen(5);
    }

    private UIElement findElement(String text) {
        if (this.settings.platform == PlatformType.Android) {
            return this.findElement(text);
        } else {
            return this.wait.waitForVisible(MobileBy.AccessibilityId(text));
        }
    }
}
