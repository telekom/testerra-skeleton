package eu.tsystems.mms.tic.ioc;

import com.google.inject.AbstractModule;
import eu.tsystems.mms.tic.testframework.pageobjects.PageObjectFactory;
import factories.MyPageFactory;

public class XConfigureCustomPageFactory extends AbstractModule {
    @Override
    protected void configure() {
        bind(PageObjectFactory.class).to(MyPageFactory.class);
    }
}
