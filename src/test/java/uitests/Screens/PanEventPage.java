package uitests.Screens;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Find;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PanEventPage {
    private Find find;
    private HomePageExtended homePageExtended;

    public PanEventPage(HomePageExtended homePageExtended) {
        this.find = homePageExtended.find;
        this.homePageExtended = homePageExtended;
    }

    public UIElement testElement() {
        return this.find.byText("target");
    }

    public void clearOutput() {
        btnClear().tap();
    }

    public String output() {
        UIElement element = null;
        if (this.homePageExtended.settings.platform == PlatformType.Android) {
            element = this.find.byLocator(this.homePageExtended.locators.editTextLocator());
        } else if (this.homePageExtended.settings.platform == PlatformType.iOS) {
            element = this.find.byText("output");
        }

        return element.getText();
    }

    public boolean loaded() {
        this.homePageExtended.navigateTo("pan");
        return this.btnClear() != null;
    }

    public boolean assertPoints(String outputText) {
        String result = outputText.replaceAll("([^0-9?!\\.\\[\\]\\s])", "");
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(result);
        ArrayList<CustomPoint> coordinates = new ArrayList<CustomPoint>();

        while (m.find()) {
            String digitsAsString = m.group(1);
            System.out.println(digitsAsString);
            String[] numbers = digitsAsString.trim().split(" ");
            double num1 = Double.parseDouble(numbers[0].trim());
            double num2 = Double.parseDouble(numbers[1].trim());
            coordinates.add(new CustomPoint(num1, num2));
        }

        for (int i = 0; i < coordinates.size(); i++) {
            if (i > 2 && i < coordinates.size() - 1) {
                if (!(coordinates.get(i - 1).X < coordinates.get(i).X) || !(coordinates.get(i - 1).Y < coordinates.get(i).Y)) {
                    this.homePageExtended.log.info(String.format("X: %s ; Y: %s", coordinates.get(i).X, coordinates.get(i).Y));
                    return false;
                }
            } else if (i == coordinates.size() - 1) {
                if (!(coordinates.get(i - 1).X <= coordinates.get(i).X) || !(coordinates.get(i - 1).Y <= coordinates.get(i).Y)) {
                    this.homePageExtended.log.info(String.format("X: %s ; Y: %s", coordinates.get(i).X, coordinates.get(i).Y));
                    this.homePageExtended.log.info(String.format("X: %s ; Y: %s", coordinates.get(i).X, coordinates.get(i).Y));
                    return false;
                }
            }
        }

        return true;
    }

    public void navigateBack() {
        this.homePageExtended.navigateBack();
    }

    private UIElement btnClear() {
        return this.find.byTextContains("clear");
    }
}

class CustomPoint {
    public double X;
    public double Y;

    CustomPoint(double x, double y) {
        this.X = x;
        this.Y = y;
    }
}
