package ist.com.springframelibrary.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.WindowDecorActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;

import ist.com.springframelibrary.R;

/**
 * Created by minyuchun on 2018/3/22.
 */

public abstract class BActivity extends AppCompatActivity{
    /**头部的标题栏*/
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (setLayoutView() > 0){//use own view
            setContentView(setLayoutView());
        }else {//use baseView include toolbar and BottomNavigationView
            setContentView(R.layout.activity_b);//设置页面
            ActionBar ab = getSupportActionBar();
            if (ab instanceof WindowDecorActionBar) {
                throw new RuntimeException("you should change your theme");
            }else {
                //get toolbar
                mToolbar = findViewById(R.id.toolbar);
                setSupportActionBar(mToolbar);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 设置基础页面
     * @return 基础页面的id
     */
    protected abstract int setLayoutView();

    /**
     *  set ToolBar and NavigationBar
     */
    protected abstract void setToolBar();

    /**
     * Activity 跳转
     * @param cls  需要跳转的ActivityClass
     * @param bundle 附加信息
     */
    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void changeToolbarTitle(@NonNull CharSequence title){
        if (mToolbar != null){
            getSupportActionBar().setTitle(title);
        }
    }

    /**
    protected void setToolBarAndNavigationBarDemo(){
    }
     */
}
