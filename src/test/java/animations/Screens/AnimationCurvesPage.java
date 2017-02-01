package animations.Screens;

import functional.tests.core.exceptions.AppiumException;

public class AnimationCurvesPage extends DemoPage {

    public AnimationCurvesPage(HomePage homePage){
        super(homePage);
    }

    public Boolean loaded() throws AppiumException {
        if (this.btn("Custom") != null) {
           this.log.info("AnimationCurves SdkPage loaded.");
            return true;
        } else {
           this.log.error("AnimationCurves SdkPage NOT loaded.");
            return false;
        }
    }
}