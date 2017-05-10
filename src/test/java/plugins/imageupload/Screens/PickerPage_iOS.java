package plugins.imageupload.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.settings.Settings;
import org.openqa.selenium.By;

import java.util.List;

public class PickerPage_iOS extends BasePage {

    public PickerPage_iOS(MobileContext contex) {
        super(contex);
    }

    private static By albumLocator() {
        return By.id("Albums");
    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() {
        this.wait.waitForVisible(albumLocator(), true);
        this.log.info("ImagePicker menu loaded.");
    }

    /**
     * Pick images from album
     **/
    public void pickImages(String albumName, int imageCount) {
        UIElement album = this.find.byLocator(By.id(albumName));
        album.tap(1);
        this.log.info("Open " + albumName + " album");

        List<UIElement> imagesList = this.find.elementsByLocator(By.xpath(String.format("%s%s","//XCUIElementTypeOther/XCUIElementTypeOther/",this.context.uiElementClass.imageLocator())));
        for (int i = 0; i < imageCount; i++) {
            imagesList.get(i).tap(1);
            this.log.info("Tap image with id: " + String.valueOf(i));
        }

        UIElement doneButton;
        if (imageCount == 1) {
            doneButton = this.find.byLocator(By.id("Done"));
        } else {
            doneButton = this.find.byLocator(By.id("Done (" + String.valueOf(imageCount) + ")"));
        }
        doneButton.tap(1);
        this.log.info("Tap Done button.");
    }
}
