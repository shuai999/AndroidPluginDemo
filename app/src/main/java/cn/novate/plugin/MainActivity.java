package cn.novate.plugin;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;

import cn.novate.plugin.plugin.PluginManager;

public class MainActivity extends AppCompatActivity {


    // File.separator 表示 /
    // yaoyiyao.apk：这个就是放在手机存储目录中打包的摇一摇的apk
    private String apkPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "yaoyiyao.apk" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click(View view){
        // 启动插件，假设插件已经下载好了，就是把YaoYiYao项目运行后获取apk文件，
        // 然后把该apk文件复制到手机存储目录中，就表示我们已经从服务器中下载好了插件

        /** 下边代码只是我们用于演示从MainActivity 通过 Hook 的 LaunchActivity跳转到 TestActivity*/
        /*Intent intent = new Intent(MainActivity.this , TestActivity.class) ;
        startActivity(intent);*/


        /*Intent intent = new Intent() ;
        // 这种写法肯定会报错，因为 该包名下的 MainActivity 找不到
        intent.setClassName(getPackageName() , "cn.novate.yaoyiyao.MainActivity") ;
        intent.putExtra("user_name" , "Novate") ;
        startActivity(intent);*/


        // 下边是调用 360的DroidPlugin的 启动插件方法
        // 一定要这样
        PackageManager pm =  getPackageManager();
        // 有了apk路径是可以获取apk的包名
        PackageInfo info = pm.getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);
        String packageName = info.packageName;
        Intent intent = pm.getLaunchIntentForPackage(packageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("user_name","Novate");
        startActivity(intent);
    }


    /**
     * 点击安装apk
     */
    public void install(View view){
//        PluginManager.install(this , apkPath);


        // 下边是调用 360的DroidPlugin的 installPackage()方法
        try {
            int result = com.morgoo.droidplugin.pm.PluginManager.getInstance().installPackage(apkPath, 0);
            Log.e("TAG","result = "+result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
