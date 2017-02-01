package plugins.admob.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage( ) {
        super();
        this.loaded();
    }

    private UIElement tabDemo() {
        return this.find.byText("Demo");
    }

    private UIElement btnSmartBanner() {
        return this.find.byText("smart banner");
    }

    public UIElement btnHideBanner() {
        return this.find.byText("hide banner");
    }

    public void tapDemoBtn() {
        this.tabDemo().click();
       this.log.info("Tap on 'Demo' tap.");
    }

    public void tapSmartBannerBtn() {
        this.btnSmartBanner().click();
       this.log.info("Tap on 'Smart Banner' button.");
    }

    public void loaded() {
        if (this.tabDemo() != null) {
           this.log.info("AdMob app loaded.");
        } else {
            Assert.fail("AdMob app NOT loaded.");
        }
    }
}
