package clwang.chunyu.me.wcl_dagger_demo;

import clwang.chunyu.me.wcl_dagger_demo.list.ReposListActivity;

/**
 * Dagger2的图接口
 * <p/>
 */
public interface DemoGraph {
    void inject(MainActivity mainActivity); // 注入MainActivity

    void inject(ReposListActivity reposListActivity); // 注入列表Activity
}
