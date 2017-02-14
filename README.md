# 依赖注入库 Dagger2 的使用方法
Dagger2+ButterKnife+RxAndroid+RxJava+Retrofit+Annotation+RecyclerView综合应用

推荐用法：Dagger2结合MVP实现完美的配合

---

基础概念：
* @Inject 主要有两个作用，一个是使用在构造函数上，通过标记构造函数让Dagger2来使用（Dagger2通过Inject标记可以在需要这个类实例的时候来找到这个构造函数并把相关实例new出来）从而提供依赖，另一个作用就是标记在需要依赖的变量让Dagger2为其提供依赖。
* @Provide 用来标注一个方法，该方法可以在需要提供依赖时被调用，从而把预先提供好的对象当做依赖给标注了@Injection的变量赋值。provide主要用于标注Module里的方法
* @Module 用来标注的类是专门用来提供依赖的。有的人可能有些疑惑，看了上面的@Inject，需要在构造函数上标记才能提供依赖，那么如果我们需要提供 的类构造函数无法修改怎么办，比如一些jar包里的类，我们无法修改源码。这时候就需要使用Module了。Module可以给不能修改源码的类提供依 赖，当然，能用Inject标注的通过Module也可以提供依赖
* @Component 一般用来标注接口，被标注了Component的接口在编译时会产生相应的类的实例来作为提供依赖方和需要依赖方之间的桥梁，把相关依赖注入到其中。
* @Scope: 可是非常的有用，Dagger2可以通过自定义注解限定注解作用域。后面会演示一个例子，这是一个非常强大的特点，因为就如前面说的一样，没必要让每个对象都去了解如何管理他们的实例。
* Qualifier: 当类的类型不足以鉴别一个依赖的时候，我们就可以使用这个注解标示。例如：在Android中，我们会需要不同类型的context，所以我们就可以定义 qualifier注解“@ForApplication”和“@ForActivity”，这样当注入一个context的时候，我们就可以告诉 Dagger我们想要哪种类型的context。

注意：在代码编写过程中 我们会发现DaggerActivityComponent会不存在，这是因为注入器是在编译的过程中才生成，所以我们在对注入器编写完成后Make Project 一下就会生成DaggerActivityComponent

---
此处我们有两种方式可以提供依赖，一个是注解了@Inject的构造方法，一个是在Module里提供的依赖，那么Dagger2是怎么选择依赖提供的呢，规则是这样的：
* 步骤1：查找Module中是否存在创建该类的方法。
* 步骤2：若存在创建类方法，查看该方法是否存在参数
 * 步骤2.1：若存在参数，则按从步骤1开始依次初始化每个参数
 * 步骤2.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束
* 步骤3：若不存在创建类方法，则查找Inject注解的构造函数，看构造函数是否存在参数
 * 步骤3.1：若存在参数，则从步骤1开始依次初始化每个参数
 * 步骤3.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束
 

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
