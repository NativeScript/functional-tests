package perfapp;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.utils.FileSystem;

import java.io.File;

public class PerformanceBaseTest extends MobileTest {

    public final static String backgroundImage = "background-image";
    public final static String properties = "properties";
    public final static String flexbox = "flexbox";

    protected perfapp.PerformanceBasePage performanceBasePage;

    public static void logPerformanceToCsv(MobileContext context, String content, String header) {
        String logFullName = context.settings.perfDir + File.separator + context.getTestName() + "_" + context.settings.platform.name().toLowerCase() + ".cvs";
        FileSystem.writeCsvFile(logFullName, content, header);
    }
}
