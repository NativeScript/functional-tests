package uitests.Tests.Gestures;

import functional.tests.core.enums.PlatformType;
import org.testng.annotations.Test;

public class ConsoleTests extends GesturesBaseTest {

    @Test(groups = {"android", "ios"})
    public void console_01() throws Exception {
        this.homePageExtended.navigateTo("console");
        this.homePageExtended.wait.waitForVisible(this.locators.byText("Check", false, false), 6, false);

        this.device.assertLogContains("true");
        this.device.assertLogContains("false");
        this.device.assertLogContains("null");
        this.device.assertLogContains("undefined");

        this.device.assertLogContains("-1");
        this.device.assertLogContains("text");
        this.device.assertLogContains("[object Object]"); // Object {name: "John", age: 34}

        if (this.settings.platform == PlatformType.Android) {
            this.device.assertLogContains("number: -1");
            this.device.assertLogContains("string: text");
            this.device.assertLogContains("text -1.000000");

            this.device.assertLogContains("0 not equals 1");
            this.device.assertLogNotContains("1 equals 1");

            this.device.assertLogContains("=== dump(): dumping members ===");
            this.device.assertLogContains("=== dump(): object is 'null' ===");
            // BaseDevice.assertLogContains("=== dump(): object is 'undefined' ===");
            this.device.assertLogContains("=== dump(): dumping function and properties names ===");
            this.device.assertLogContains("=== dump(): finished ===");

            this.device.assertLogContains("\"name\": \"John\",");
            this.device.assertLogContains("\"age\": 34");
            this.device.assertLogContains("\"abc\": \"Hello\",");
            this.device.assertLogContains("\"circular\": \"#CR:[object Object]\""); // #CR:Object {name: "John", age: 34}

            this.device.assertLogContains("\"view\": \"#CR:Button");
            this.device.assertLogContains("constructor()");

            this.device.assertLogContains("Stack Trace:");
            this.device.assertLogContains("at pageLoaded");
            this.device.assertLogContains("console.time(Time):");
        } else if (this.settings.platform == PlatformType.iOS) {
            this.device.assertLogContains("number: %i -1");
            this.device.assertLogContains("string: %s text");
            this.device.assertLogContains("%s %f text -1");

            this.device.assertLogContains("CONSOLE LOG");
            this.device.assertLogContains("CONSOLE INFO");
            this.device.assertLogContains("CONSOLE WARN");
            this.device.assertLogContains("CONSOLE ERROR");

            this.device.assertLogContains("%d not equals %d 0 1");
            this.device.assertLogNotContains("1 equals 1");

            this.device.assertLogContains("CONSOLE TRACE");
            this.device.assertLogContains("0: pageLoaded");
        }

        this.device.assertLogContains("info");
        this.device.assertLogContains("warn");
        this.device.assertLogContains("error");
        this.device.assertLogContains("### TEST END ###");
    }
}
