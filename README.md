:running:OkVolley-Android:running:
============

将Volley+OkHttp+Gson的常用功能抽成一个Library，以便自己平时练习时用于请求网络数据，分支自BGAOkVolley-Android

1. Volley用于普通数据加载

2. 文件上传下载是用的OkHttp，同时支持进度回调

3. 处理了返回结果的Unicode字符

还加了RoundedNetworkImageView类：

1. 支持在布局文件中预览、配置默认图片和失败时的图片

2. 支持圆角和圆形图像

### Gradle依赖 [ ![Download](https://api.bintray.com/packages/bingoogolapple/maven/bga-okvolley/images/download.svg) ](https://bintray.com/bingoogolapple/maven/bga-okvolley/_latestVersion)

```groovy
dependencies {
    compile 'com.android.support:appcompat-v7:23.0.0'

    compile 'cn.bingoogolapple:bga-okvolley:latestVersion@aar'
    compile 'com.mcxiaoke.volley:library:1.0.18'
    compile('com.squareup.okhttp:okhttp:2.4.0') {
        exclude group: 'com.squareup.okio', module: 'okio'
    }
    compile 'com.squareup.okhttp:okhttp-urlconnection:2.4.0'
    compile 'com.squareup.okio:okio:1.5.0'
    compile 'com.google.code.gson:gson:2.3.1'
    compile 'cn.pedant.sweetalert:library:1.3'
}
```


### 更多详细用法请查看[Demo](https://github.com/bingoogolapple/BGAOkVolley-Android/tree/master/demo)
