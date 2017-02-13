package clwang.chunyu.me.wcl_dagger_demo.modules;

import android.app.Application;
import android.content.res.Resources;

import javax.inject.Singleton;

import clwang.chunyu.me.wcl_dagger_demo.DemoApplication;
import dagger.Module;
import dagger.Provides;

/**
 * 主要模块, 提供Application和resources.
 * <p/>
 */
@Module
public class MainModule {
    private final DemoApplication mApp;

    public MainModule(DemoApplication application) {
        mApp = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication() {
        return mApp;
    }

    @Provides
    @Singleton
    protected Resources provideResources() {
        return mApp.getResources();
    }
}