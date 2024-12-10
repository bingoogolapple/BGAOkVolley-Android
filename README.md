:running:BGAOkVolley-Android:running:
============

将Volley+OkHttp+Gson的常用功能抽成一个Library，以便自己平时练习时用于请求网络数据
1. Volley用于普通数据加载
2. 文件上传是用的OkHttp

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

## 作者联系方式

| 个人主页 | 邮箱 |
| ------------- | ------------ |
| <a  href="https://www.bingoogolapple.cn" target="_blank">bingoogolapple.cn</a>  | <a href="mailto:bingoogolapple@gmail.com" target="_blank">bingoogolapple@gmail.com</a> |

| 个人微信号 | 微信群 | 公众号 |
| ------------ | ------------ | ------------ |
| <img width="180" alt="个人微信号" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/BGAQrCode.png"> | <img width="180" alt="微信群" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/WeChatGroup1QrCode.jpg"> | <img width="180" alt="公众号" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/GongZhongHao.png"> |

| 个人 QQ 号 | QQ 群 |
| ------------ | ------------ |
| <img width="180" alt="个人 QQ 号" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/BGAQQQrCode.jpg"> | <img width="180" alt="QQ 群" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/QQGroup1QrCode.jpg"> |

## 打赏支持作者

如果您觉得 BGA 系列开源库或工具软件帮您节省了大量的开发时间，可以扫描下方的二维码打赏支持。您的支持将鼓励我继续创作，打赏后还可以加我微信免费开通一年 [上帝小助手浏览器扩展/插件开发平台](https://github.com/bingoogolapple/bga-god-assistant-config) 的会员服务

| 微信 | QQ | 支付宝 |
| ------------- | ------------- | ------------- |
| <img width="180" alt="微信" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/donate-wechat.jpg"> | <img width="180" alt="QQ" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/donate-qq.jpg"> | <img width="180" alt="支付宝" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/donate-alipay.jpg"> |

## 作者项目推荐

* 欢迎您使用我开发的第一个独立开发软件产品 [上帝小助手浏览器扩展/插件开发平台](https://github.com/bingoogolapple/bga-god-assistant-config)
