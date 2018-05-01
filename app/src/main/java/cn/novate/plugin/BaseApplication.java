package cn.novate.plugin;

import android.app.Application;

import com.morgoo.droidplugin.PluginApplication;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/4/30 8:41
 * Version 1.0
 * Params:
 * Description:
*/

public class BaseApplication extends PluginApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        /*HookStartActivityUtil hookStartActivityUtil = new HookStartActivityUtil(this , ProxyActivity.class) ;
        try {
            hookStartActivityUtil.hookStartActivity();
            hookStartActivityUtil.hookLaunchActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
