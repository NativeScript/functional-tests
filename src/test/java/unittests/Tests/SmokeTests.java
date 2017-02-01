package unittests.Tests;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.enums.DeviceType;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.utils.OSUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import unittests.Screens.HomePage;

import java.util.HashMap;

public class SmokeTests extends UIBaseTest {

    @Test(groups = {"android", "ios"})
    public void runTests() throws Exception {
        HomePage homePage = new HomePage();

        // Allow tests to access photos, media, and files on the device
        if (this.settings.platform == PlatformType.Andorid && this.settings.platformVersion >= 6.0) {
            homePage.find.byText("Allow").click();
        }

        boolean result = homePage.waitForTestsToComplete();

        HashMap<Double, String> paths = new HashMap<Double, String>();
        paths.put(4.2, "/mnt/sdcard/Documents/test-results.xml");
        paths.put(5.0, "/storage/sdcard/Documents/test-results.xml");
        paths.put(6.0, "/storage/emulated/0/Documents/test-results.xml");

        try {
            String pathTestResults;
            if (this.settings.platformVersion == 4.2) {
                pathTestResults = paths.get(4.2).toString();
            } else if (this.settings.platformVersion >= 6.0) {
                pathTestResults = paths.get(6.0).toString();
            } else {
                pathTestResults = paths.get(5.0).toString();
            }

            if (this.settings.platform == PlatformType.Andorid) {
                this.device.pullFile(pathTestResults, null);
            }

            // TODO(vchimev): Refactor this code.
            if (this.settings.deviceType == DeviceType.Simulator) {
                String resultFileRow = OSUtils.runProcess("find ~/Library/Developer/CoreSimulator/Devices/" +
                        this.settings.deviceId + " -name test-results.xml");
                String[] rowList = resultFileRow.split("\\r?\\n");
                String resultFile = resultFileRow;
                for (String rowLine : rowList) {
                    if (rowLine.contains("CoreSimulator")) {
                        resultFile = rowLine.trim();
                    }
                }
                OSUtils.runProcess("cp " + resultFile + " " + this.settings.baseLogDir);
            }
            if (this.settings.deviceType == DeviceType.iOS) {
                // TODO: Find some way to get logs.
            }
        } catch (Exception e) {
            this.log.fatal("Failed to get JUnit tests result file!");
            this.log.fatal(e.getMessage());
        }

        Assert.assertTrue(result, "There are failing unit tests!");
    }
}
