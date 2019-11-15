package eu.tsystems.mms.tic.ioc;

import com.google.inject.AbstractModule;
import eu.tsystems.mms.tic.testframework.pageobjects.IPageFactory;
import factories.MyPageFactory;

public class ConfigureCustomFactories extends AbstractModule {
    @Override
    protected void configure() {
        bind(IPageFactory.class).to(MyPageFactory.class);
    }
}
