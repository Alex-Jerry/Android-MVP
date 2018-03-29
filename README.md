# Android-MVP
最好用的android-mvp框架，包含了rxjava+retrofit+okhttp的网络框架、6.0动态授权、以及activity、fragment的基类封装等

## 一、有哪些功能：
##### 1、框架整体基于MVP架构，结合了rxjava+retrofit+okhttp的网络框架，Demo项目结构如下：

![项目Demo结构样例](https://user-gold-cdn.xitu.io/2018/3/29/16270da637ff0190?w=548&h=501&f=jpeg&s=24481)
##### 2、框架封装了BaseActivity、BaseFragment等基类
##### 3、框架封装了6.0动态授权在BaseActivity中，动态授权可以一行代码直接调用，如下：

![动态授权](https://user-gold-cdn.xitu.io/2018/3/29/16270e01822c82a8?w=1204&h=416&f=png&s=21882)
##### 4、下面大致截图讲解下如何使项目升级为mvp结构：

![MVP](https://user-gold-cdn.xitu.io/2018/3/29/16270e8220f79c34?w=747&h=888&f=png&s=46780)
如上图，MainContract主要负责拆分MainActivity中所需要的接口以及MainPresenter层实现之后的回调接口（有点拗口），
举例：如上图中，IMainView接口中主要负责回调给上层activity的一些方法，这里是回调（就是在MainPresenter层实现了IMainPresenter接口中的各种方法之后的回调），那么IMainPresenter接口就是负责MainPresenter层需要实现的各种接口咯。
那么我们再看MainPresenter层的实现,如下图：

![Presenter层结构](https://user-gold-cdn.xitu.io/2018/3/29/16270f28c2c0ebce?w=1319&h=1101&f=jpeg&s=109668)
最后再来看下MainActivity层,如下图：

![Activity层结构](https://user-gold-cdn.xitu.io/2018/3/29/16270f7a35619a12?w=1484&h=1206&f=png&s=86100)

## 二、使用：
##### 1、先依赖mvplib包到主项目中
##### 2、有时间慢慢详细讲解，具体使用方式请先参照Demo样例

