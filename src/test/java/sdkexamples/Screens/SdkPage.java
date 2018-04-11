package sdkexamples.Screens;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.Position;
import functional.tests.core.mobile.basepage.BasePageExtended;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import functional.tests.core.enums.SwipeElementDirection;

import java.util.*;

public class SdkPage extends BasePageExtended {

    Set<String> allLinks = new HashSet<String>();
    TreeSet<String> allSortedLinks = new TreeSet<String>();

    public SdkPage(MobileContext context) {
        super("", context);
    }

    public List<UIElement> getLinks() {
        List<UIElement> elements = null;
        if (this.settings.platform == PlatformType.Android) {
            elements = this.find.elementsByLocator(this.locators.textFieldLocator());
        } else if (this.settings.platform == PlatformType.iOS) {
            elements = this.find.elementsByLocator(this.locators.labelLocator());
            elements.remove(0);

        }
        return elements;
    }

    public List<String> getLinksText() {
        List<String> linksText = new ArrayList<String>();
        List<UIElement> links = this.getLinks();
        for (UIElement link : links) {
            linksText.add(link.getText());
        }
        return linksText;
    }

    public Set<String> getMainMenuLinks() {
        List<String> listVisibleLinks;
        Set<String> setAllLinks = new HashSet<String>();
        int count = 0;

        if (this.settings.platform == PlatformType.Android) {
            while (count < 4) {

                // Get the visible links
                listVisibleLinks = this.getLinksText();
                for (String linkText : listVisibleLinks) {
                    setAllLinks.add(linkText);
                }

                // Swipe down
                this.gestures.scrollInWindow(SwipeElementDirection.DOWN, Position.FromCorner, 0);
                count++;
            }

            while (count > 0) {
                // Swipe up
                this.gestures.scrollInWindow(SwipeElementDirection.UP, Position.FromCorner, 0);
                count--;
            }
        } else if (this.settings.platform == PlatformType.iOS) {
            listVisibleLinks = this.getLinksText();
            for (String linkText : listVisibleLinks) {
                setAllLinks.add(linkText);
            }
        }

        this.log.info("Links:\n" + setAllLinks.toString());
        this.allLinks = setAllLinks;
        return this.allLinks;
    }

    public TreeSet<String> getSortedMainMenuLinks() {
        if (this.allLinks.isEmpty()) {
            this.getMainMenuLinks();
        }
        TreeSet<String> setAllSortedLinks = new TreeSet<String>(this.allLinks);
        this.log.info("Sorted Links:\n" + setAllSortedLinks.toString());
        this.allSortedLinks = setAllSortedLinks;
        return this.allSortedLinks;
    }

    public int getMainMenuLinksSize() {
        if (this.allLinks.isEmpty()) {
            this.getMainMenuLinks();
        }
        int size = this.allLinks.size();
        this.log.info("Links Count: " + size);
        return size;
    }

    public void logScreenshot(String value) {
        if (this.settings.platform == PlatformType.Android) {
            this.log.info("Waiting for 1 second ...");
            Wait.sleep(1000);
            if (this.settings.isRealDevice) {
                Wait.sleep(1000);
            }
            this.log.info("It's gone!");
        }
        this.log.logScreen(value);
    }
}
