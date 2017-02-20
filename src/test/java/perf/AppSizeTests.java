package perf;

import functional.tests.core.mobile.basetest.BaseTest;
import functional.tests.core.utils.FileSystem;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class AppSizeTests extends BaseTest {

    private String BASE_PATH = this.settings.BASE_TEST_APP_DIR + File.separator;

    @Test()
    public void cuteness_size_01_apk() {
        float size = FileSystem.getFileSize(BASE_PATH + "CutenessIO-release.apk");
        this.log.info("Size of CutenessIO-release.apk is " + String.valueOf(size) + " KB");
        Assert.assertTrue(size > 11200, ".apk size decreased below 11200 KB.");
        Assert.assertTrue(size < 11250, ".apk size increased over 11250 KB.");
    }

    @Test()
    public void size_02_ipa() {
        float size = FileSystem.getFileSize(BASE_PATH + "CutenessIO.ipa");
        this.log.info("Size of CutenessIO.ipa is " + String.valueOf(size) + " KB");
        Assert.assertTrue(size > 12000, ".ipa size decreased below 12000 KB.");
        Assert.assertTrue(size < 12500, ".ipa size increased over 12500 KB.");
    }

    @Test()
    public void size_03_app_tgz() {
        float size = FileSystem.getFileSize(BASE_PATH + "CutenessIO.tgz");
        this.log.info("Size of CutenessIO.tgz is " + String.valueOf(size) + " KB");
        Assert.assertTrue(size > 12000, ".tgz size decreased below 12000 KB.");
        Assert.assertTrue(size < 12500, ".tgz size increased over 12500 KB.");
    }
}
