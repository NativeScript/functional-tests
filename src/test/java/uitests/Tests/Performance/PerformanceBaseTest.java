package uitests.Tests.Performance;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.utils.FileSystem;
import org.testng.annotations.BeforeClass;
import uitests.Screens.Performance.PerformanceBasePage;

import java.io.File;
import java.io.IOException;

public class PerformanceBaseTest extends MobileTest {

    public final static String performance = "perf";
    public final static String memoryTests = "memory-leaks";
    public final static String backgroundImage = "background-image";
    public final static String properties = "properties";

    protected PerformanceBasePage performanceBasePage;

    @BeforeClass(alwaysRun = true)
    public void beforePerformanceBaseTest() {
        this.performanceBasePage = new PerformanceBasePage(PerformanceBaseTest.performance, this.context);
        this.performanceBasePage.navigateTo(PerformanceBaseTest.performance);
    }

    public static String getLogFullFileName(MobileContext context) {
        String logFullName = context.settings.perfDir + File.separator + "perf" + File.separator + context.settings.testAppName + File.separator + context.getTestName() + "_" + context.settings.platform.name().toLowerCase() + ".cvs";
        ensureFileExists(logFullName);

        return logFullName;
    }

    public static void logPerformanceToCsv(String fileFullName, String content) {
        try {
            if (FileSystem.exist(fileFullName)) {
                FileSystem.appendFile(fileFullName, content);
            } else {
                FileSystem.writeFile(fileFullName, "" + content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void ensureFileExists(String logFullName) {
        File f = new File(logFullName);
        if (!f.exists()) {
            File d = new File(f.getParent());
            if (!d.exists()) {
                d.mkdirs();
            }
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
