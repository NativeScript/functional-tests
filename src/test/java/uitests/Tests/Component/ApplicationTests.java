package uitests.Tests.Component;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.find.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplicationTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void application_01_launch_resume() throws Exception {
        if (this.settings.platform == PlatformType.Android) {
            this.app.restart();
            Wait.sleep(3000);
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
        Wait.sleep(3000);
        this.device.assertLogContains("#1# SuspendEvent");
        if (this.settings.platform != PlatformType.iOS && !this.settings.platformVersion.toString().startsWith("9")) {
            this.device.assertLogContains("#2# ResumeEvent");
        }
    }

    @Test(groups = {"android", "ios"})
    public void tabview_with_scrollview_4022() throws Exception {
        this.context.navigationManager.navigateTo("tabview-with-scrollview_4022");
        this.context.find.byText("Tab 2").tap();
        this.log.info("Run the application in background.");
        this.app.runInBackground(5);
        this.context.wait.waitForVisible(this.locators.byText("Tab 1")).tap();
        this.context.wait.waitForVisible(this.locators.byText("Tab 2")).tap();
        this.context.wait.waitForVisible(this.locators.byText("Tab 3")).tap();

        this.assertScreen(5);
    }
}
