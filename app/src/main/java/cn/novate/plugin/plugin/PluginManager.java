package cn.novate.plugin.plugin;

import android.content.Context;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/1 9:26
 * Version 1.0
 * Params:
 * Description:
*/

public class PluginManager {

    public static final void install(Context context , String apkPath){

        try {
            // 解决类加载的问题
            FixDexManager fixDexManager = new FixDexManager(context) ;
            // 这个就相当于 把 apk的 class 加载到 ApplicationClassLoader
            fixDexManager.fixDex(apkPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
