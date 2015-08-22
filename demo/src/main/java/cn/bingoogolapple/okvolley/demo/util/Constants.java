package cn.bingoogolapple.okvolley.demo.util;

import java.io.File;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/8/22 下午3:46
 * 描述:
 */
public class Constants {

    private Constants() {
    }

    public static final String APP_NAME = "BGAOkVolley";

    public static final class file {
        // 应用程序主目录
        public static final String DIR_ROOT = APP_NAME;
        // 应用程序图像资源目录
        public static final String DIR_IMAGE = DIR_ROOT + File.separator + "images";
        // 应用程序文件目录
        public static final String DIR_FILE = DIR_ROOT + File.separator + "file";
    }
}
