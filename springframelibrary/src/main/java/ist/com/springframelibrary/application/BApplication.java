package ist.com.springframelibrary.application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import ist.com.springframelibrary.activity.CActivity;

/**
 * Created by minyuchun on 2018/3/22.
 * 上下文
 */

public class BApplication extends Application {
    //长期持有以下对象不清除回造成内存泄漏问题，一般不建议这样长期持有
    @SuppressLint("StaticFieldLeak")
    private static Context sContext;
    @SuppressLint("StaticFieldLeak")
    protected static BApplication sApp;
    /**activity lifecycle callback*/
    public static ActivityLifecycleCallbacks sCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            CActivity.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
        }

        @Override
        public void onActivityResumed(Activity activity) {
            CActivity.resume(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {
        }

        @Override
        public void onActivityStopped(Activity activity) {
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            CActivity.remove(activity);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();//get context
        sApp = (BApplication) getApplicationContext();//get instance
        registerActivityLifecycleCallbacks(sCallbacks);// add activity lifeCycle callback
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //配置改变时触发这个方法 如翻转屏幕
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        //This method is for use in emulated process environments.
        // 用于模拟环境
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ////APP优化-- 缓存管理必须关注 //api 1 以上
        //This is called when the overall system is running low on memory, and actively running processes should trim their memory usage
        //手机系统低内存时触发，app应该在此清理不必要的内存
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        //APP优化-- 缓存管理必须关注 //api 14 以上
        //Called when the operating system has determined that it is a good time for a process to trim unneeded memory from its process.
        // 按照 level 的回调调用，用于APP逐步清理内存，通过调整等级使得app能运行的时间更长
        //https://developer.android.google.cn/reference/android/app/Application#onTrimMemory(int)
        //level 回调说明
        //https://developer.android.google.cn/reference/android/content/ComponentCallbacks2
        /*
         * level 类型
         * //APP还在运行
         * TRIM_MEMORY_RUNNING_MODERATE：系统可用内存较低，正在杀掉 LRU缓存中的进程。你的进程正在运行，没有被杀掉的危险。
         * TRIM_MEMORY_RUNNING_LOW：系统可用内存更加紧张，程序虽然暂没有被杀死的危险，但是应该尽量释放一些资源，以提升系统的性能（这也会直接影响你程序的性能）。
         * TRIM_MEMORY_RUNNING_CRITICAL：系统内存极度紧张，而LRU缓存中的大部分进程已被杀死，如果仍然无法获得足够的资源的话，接下来会清理掉 LRU 中的所有进程，并且开始杀死一些系统通常会保留的进程，比如后台运行的服务等
         * //应用的可见性发展改变时
         * TRIM_MEMORY_UI_HIDDEN: UI不可见，可以释放UI资源。
         * //应用缓存列表发生该表
         * TRIM_MEMORY_BACKGROUND：系统可用内存低，而你的程序处在 LRU的顶端，因此暂时不会被杀死，但是此时应释放一些程序再次打开时比较容易恢复的 UI 资源。
         * TRIM_MEMORY_MODERATE：系统可用内存低，程序处于 LRU的中部位置，如果内存状态得不到缓解，程序会有被杀死的可能。
         * TRIM_MEMORY_COMPLETE：系统可用内存低，你的程序处于 LRU尾部，如果系统仍然无法回收足够的内存资源，你的程序将首先被杀死。此时应释放无助于恢复程序状态的所有资源。
         */
        //额外 -- 三级缓存  https://www.cnblogs.com/itgungnir/p/6211002.html
    }
    /**get context*/
    public static Context getContext() {
        if (sContext == null)
            throw new NullPointerException("你需要在你的项目中集成App，并且在AndroidManifest.xml中应用");
        return sContext;
    }
    /**get instance*/
    public static BApplication getApp() {
        return sApp;
    }


}
