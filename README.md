# 依赖注入库 Dagger2 的使用方法
Dagger2+ButterKnife+RxAndroid+RxJava+Retrofit+Annotation+RecyclerView综合应用

```java
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:23.1.1'
    compile 'com.android.support:recyclerview-v7:23.1.1' // RecyclerView

    compile 'com.jakewharton:butterknife:7.0.1' // 标注

    compile 'com.google.dagger:dagger:2.0.2' // dagger2
    compile 'com.google.dagger:dagger-compiler:2.0.2' // dagger2

    compile 'io.reactivex:rxandroid:1.1.0' // RxAndroid
    compile 'io.reactivex:rxjava:1.1.0' // 推荐同时加载RxJava

    compile 'com.squareup.retrofit:retrofit:2.0.0-beta2' // Retrofit网络处理
    compile 'com.squareup.retrofit:adapter-rxjava:2.0.0-beta2' // Retrofit的rx解析库
    compile 'com.squareup.retrofit:converter-gson:2.0.0-beta2' // Retrofit的gson库

    provided 'javax.annotation:jsr250-api:1.0' // Java标注
}
```
