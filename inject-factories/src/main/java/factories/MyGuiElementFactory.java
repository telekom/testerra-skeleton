package factories;

import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.DefaultGuiElementFactory;
import eu.tsystems.mms.tic.testframework.pageobjects.GuiElementFactory;
import eu.tsystems.mms.tic.testframework.pageobjects.IGuiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.IPage;
import eu.tsystems.mms.tic.testframework.pageobjects.Locate;

public class MyGuiElementFactory extends DefaultGuiElementFactory implements GuiElementFactory, Loggable {
    @Override
    public IGuiElement create(Locate locator, IPage page) {
        log().info("Enjoy your custom GuiElement");
        return super.create(locator, page);
    }
}
