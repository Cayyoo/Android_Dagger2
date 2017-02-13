package clwang.chunyu.me.wcl_dagger_demo;

import android.app.Application;

/**
 * 应用信息
 * <p/>
 */
public class DemoApplication extends Application {
    private static DemoGraph sDemoGraph;
    private static DemoApplication sInstance;

    @Override public void onCreate() {
        super.onCreate();
        sInstance = this;
        buildComponentAndInject();
    }

    public static DemoGraph component() {
        return sDemoGraph;
    }

    public static void buildComponentAndInject() {
        sDemoGraph = DemoComponent.Initializer.init(sInstance);
    }

}
