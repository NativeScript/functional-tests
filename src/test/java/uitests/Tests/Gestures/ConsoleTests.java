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

        if (this.settings.platform == PlatformType.Android) {
            final String johnObj = "{\n" +
                    "  \"name\": \"John\",\n" +
                    "  \"age\": 34\n" +
                    "}";

            this.device.assertLogContains(johnObj); // Object {name: "John", age: 34}
            //this.device.assertLogContains("-1 text " + johnObj);
            //this.device.assertLogContains("[1,5,12.5, " + johnObj + ", text, 42]"); // console.log([1, 5, 12.5, obj, str, 42]);
            this.device.assertLogContains("number: -1");
            this.device.assertLogContains("string: text");

            this.device.assertLogContains("Assertion failed:  false == true");
            this.device.assertLogContains("Assertion failed:  empty string evalutes to 'false'");
            this.device.assertLogNotContains("1 equals 1");

            this.device.assertLogContains("==== object dump start ====");
            this.device.assertLogContains("name: \"John\"");
            this.device.assertLogContains("age: \"34\"");

            this.device.assertLogContains("==== object dump end ====");

            this.device.assertLogContains("Trace: console.trace() called");
            this.device.assertLogContains("at pageLoaded");
            this.device.assertLogContains("Time:");
        } else if (this.settings.platform == PlatformType.iOS) {
            this.device.assertLogContains("[object Object]"); // Object {name: "John", age: 34}
            this.device.assertLogContains("number: -1");
            this.device.assertLogContains("string: text");
            this.device.assertLogContains("text -1");
            this.device.assertLogContains("[object Object]"); // Object {name: "John", age: 34}
            this.device.assertLogContains("CONSOLE LOG");
            this.device.assertLogContains("CONSOLE INFO");
            this.device.assertLogContains("CONSOLE WARN");
            this.device.assertLogContains("CONSOLE ERROR");

            this.device.assertLogContains("false == true");

            this.device.assertLogContains("CONSOLE TRACE");
            this.device.assertLogContains("0: pageLoaded");
        }

        this.device.assertLogContains("info");
        this.device.assertLogContains("warn");
        this.device.assertLogContains("error");
        this.device.assertLogContains("### TEST END ###");
    }
}
