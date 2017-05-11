package perfapp;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.utils.FileSystem;
import functional.tests.core.utils.OSUtils;

import java.io.File;

public class PerformanceBaseTest extends MobileTest {

    public final static String backgroundImage = "background-image";
    public final static String properties = "properties";
    public final static String flexbox = "flexbox";

    protected perfapp.PerformanceBasePage performanceBasePage;
    private final static String header = "Timestamp,Hostname,Device,Scenario";

    public static void logPerformanceToCsv(MobileContext context, String content, String header) {
        String fileName = context.getTestName() + "_" + context.settings.platform.name().toLowerCase() + ".csv";
        String logFullName = context.settings.perfDir + File.separator + fileName;
        FileSystem.writeCsvFile(logFullName, content, header);
        String localPath = context.settings.baseLogDir + File.separator + fileName;
        FileSystem.writeCsvFile(localPath, content, header);
    }

    public static void writeLine(StringBuilder sb, MobileContext context, String... args) {
        sb.append(String.format("%s,%s,%s", context.settings.buildRunStartupTime, OSUtils.getHostName(), context.device.getName()))
                .append(",")
                .append(String.join(",", args))
                .append(System.lineSeparator());
    }

    public static String writeHeader(String additionalHeader) {
        return header + "," + additionalHeader;
    }
}
