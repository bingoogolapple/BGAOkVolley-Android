package cn.bingoogolapple.okvolley.demo.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.bingoogolapple.okvolley.demo.App;
import cn.bingoogolapple.okvolley.demo.R;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/8/22 下午3:44
 * 描述:
 */
public class StorageUtil {

    private StorageUtil() {
    }

    /**
     * 判断外存储是否可写
     *
     * @return
     */
    public static boolean isExternalStorageWritable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取当前app图片文件存储路径
     *
     * @return
     */
    public static File getImageDir() {
        File imageDir = null;
        if (isExternalStorageWritable()) {
            imageDir = new File(Environment.getExternalStorageDirectory() + File.separator + Constants.file.DIR_IMAGE);
            if (!imageDir.exists()) {
                imageDir.mkdirs();
            }
        } else {
            throw new RuntimeException("外部存储不可写");
        }
        return imageDir;
    }

    /**
     * 获取当前app文件存储路径
     *
     * @return
     */
    public static File getFileDir() {
        File fileDir = null;
        if (isExternalStorageWritable()) {
            fileDir = new File(Environment.getExternalStorageDirectory() + File.separator + Constants.file.DIR_FILE);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
        } else {
            throw new RuntimeException("外部存储不可写");
        }
        return fileDir;
    }

    public static File wiriteIcLauncherToFile() {
        File icLauncherFile = new File(StorageUtil.getImageDir(), "ic_launcher.png");
        if (!icLauncherFile.exists() || icLauncherFile.length() <= 0) {
            FileOutputStream icLauncherFos = null;
            try {
                icLauncherFos = new FileOutputStream(icLauncherFile);
                BitmapFactory.decodeResource(App.getInstance().getResources(), R.mipmap.ic_launcher).compress(Bitmap.CompressFormat.PNG, 100, icLauncherFos);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (icLauncherFos != null) {
                    try {
                        icLauncherFos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return icLauncherFile;
    }
}