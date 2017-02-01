package plugins.socialshare.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.testng.Assert;


public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    private UIElement shareImageButton() {
        return this.find.byText("Share an image");
    }

    private UIElement shareTextButton() {
        return this.find.byText("Share text");
    }

    public void tapShareImageButton() {
        this.shareImageButton().click();
        this.log.info("Tap share image button.");
    }

    public void tapShareTextButton() {
        this.shareTextButton().click();
        this.log.info("Tap share text button.");
    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() {
        this.shareImageButton();
        this.shareTextButton();
        this.log.info("Social share plugin demo app loaded.");
    }

    /**
     * Verify share text dialog loaded
     **/
    public void verifyShareTextDialog() {
        if (this.settings.platform == PlatformType.Andorid) {
            if (this.settings.platformVersion.toString().contains("4.")) {
                UIElement mail = this.find.byText("Email", this.settings.defaultTimeout);
                Assert.assertNotNull(mail, "Share dialog not loaded.");
                UIElement text = this.find.byText("Messaging", this.settings.shortTimeout);
                Assert.assertNotNull(text, "Share dialog not loaded.");
            } else if (this.settings.platformVersion.toString().contains("5.")) {
                UIElement message = this.find.byText("I love NativeScript!", this.settings.defaultTimeout);
                Assert.assertNotNull(message, "Share dialog not loaded.");
            } else if (this.settings.platformVersion.toString().contains("6.")) {
                UIElement conversation = this.find.byText("Select conversation", this.settings.defaultTimeout);
                Assert.assertNotNull(conversation, "Share dialog not loaded.");
                this.find.byText("New message").click();
                UIElement allContacts = this.find.byText("All contacts", this.settings.shortTimeout);
                Assert.assertNotNull(allContacts, "Share dialog not loaded.");
            }
        } else if (this.settings.platform == PlatformType.iOS) {
            UIElement mail = this.find.byText("Mail", this.settings.shortTimeout);
            Assert.assertNotNull(mail, "Share dialog not loaded.");
        }
    }

    /**
     * Verify share image dialog loaded
     **/
    public void verifyShareImageDialog() {
        if (this.settings.platform == PlatformType.Andorid) {
            if (this.settings.platformVersion.toString().contains("4.")) {
                UIElement mail = this.find.byText("Email", this.settings.defaultTimeout);
                Assert.assertNotNull(mail, "Share dialog not loaded.");
                UIElement text = this.find.byText("Messaging", this.settings.shortTimeout);
                Assert.assertNotNull(text, "Share dialog not loaded.");
            } else if (this.settings.platformVersion.toString().contains("5.")) {
                UIElement mms = this.find.byText("MMS", this.settings.defaultTimeout);
                Assert.assertNotNull(mms, "Share dialog not loaded.");
            } else if (this.settings.platformVersion.toString().contains("6.")) {
                UIElement conversation = this.find.byText("Select conversation", this.settings.defaultTimeout);
                Assert.assertNotNull(conversation, "Share dialog not loaded.");
                this.find.byText("New message").click();
                UIElement allContacts = this.find.byText("All contacts", this.settings.shortTimeout);
                Assert.assertNotNull(allContacts, "Share dialog not loaded.");
            }
        } else if (this.settings.platform == PlatformType.iOS) {
            UIElement mail = this.find.byText("Mail", this.settings.shortTimeout);
            Assert.assertNotNull(mail, "Share dialog not loaded.");
        }
    }
}
