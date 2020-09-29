package eu.tsystems.mms.tic.ioc;

import com.google.inject.AbstractModule;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.PageFactory;
import factories.MyPageFactory;

public class XConfigureCustomPageFactory extends AbstractModule {
    @Override
    protected void configure() {
        bind(PageFactory.class).to(MyPageFactory.class);
    }
}
