package sdkexamples;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import sdkexamples.Screens.SdkMainPage;

public abstract class SdkBaseTest extends MobileTest {

    protected SdkMainPage mainPage;

    protected abstract String subMainPage();

    protected abstract Object[][] data();

    @BeforeClass
    public void beforeSdkBaseTestTestsClass() {
        this.mainPage = new SdkMainPage(this.subMainPage(), this.context);
    }

    @AfterMethod(alwaysRun = true)
    public void afterSdkBaseTestMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP) {
            result.setStatus(ITestResult.FAILURE);
            this.log.info("Set test result from SKIP to FAILURE.");
        }
        try {
            this.mainPage.navigateBack(this.mainPage.btnBack());
        } catch (Exception ex) {
            this.log.error(ex.getMessage());
            result.setStatus(ITestResult.FAILURE);
        }
    }
}
