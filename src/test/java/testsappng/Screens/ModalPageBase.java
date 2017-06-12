package testsappng.Screens;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;

public class ModalPageBase extends HomePage {
    public static final String BTN_MAIN_PAGE = "Modals";
    public static final String BTN_MODAL_NAME = "modal";
    public static final String BTN_MODAL_ON_PUSH_NAME = "modal(onPush)";
    public static final String BTN_MODAL_LAZY = "modal(lazy)";
    public static final String BTN_SHOW_COMPONENT = "show component";
    public static final String BTN_SHOW_COMPONENT_ASYNC = "show component (async)";
    public static final String BTN_LOAD_MODAL = "Load modal!";

    public ModalPageBase(MobileContext context) {
        super("", context);
        this.testsAppNgHomeNavigateToPage(ModalPageBase.BTN_MAIN_PAGE);
    }

    public void ok() {
        this.btnOk().click();
    }

    public UIElement btnOk() {
        return this.find.byText("ok", false, 6);
    }

    public void cancel() {
        this.btnCancel().click();
    }

    public UIElement btnCancel() {
        return this.find.byText("cancel", false, 6);
    }
}
