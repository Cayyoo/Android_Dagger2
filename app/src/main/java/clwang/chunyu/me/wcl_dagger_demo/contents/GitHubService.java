package clwang.chunyu.me.wcl_dagger_demo.contents;

import java.util.ArrayList;

import clwang.chunyu.me.wcl_dagger_demo.list.ListAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * GitHub服务
 * <p>
 */
public interface GitHubService {
    String ENDPOINT = "https://api.github.com";//json数据源

    // 获取库, 获取的是数组
    @GET("/users/{user}/repos")
    Observable<ArrayList<ListAdapter.Repo>> getRepoData(@Path("user") String user);
}
