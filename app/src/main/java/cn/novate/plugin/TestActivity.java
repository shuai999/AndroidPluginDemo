package cn.novate.plugin;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/4/30 17:34
 * Version 1.0
 * Params:
 * Description:
 *              如果TestActivity 继承 AppCompatActivity 就会报错
 *              解决方式如下：
 *                  参考：HookStartActivityUtil类
 *
*/

public class TestActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}
