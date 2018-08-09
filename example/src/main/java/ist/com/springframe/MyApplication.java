package ist.com.springframe;

import ist.com.springframelibrary.application.BApplication;

/**
 * Created by minyuchun on 2018/8/9.
 */

public class MyApplication extends BApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = (MyApplication) getApplicationContext();//get instance
    }

    /**get instance*/
    public static MyApplication getMyApp() {
        return (MyApplication) sApp;
    }
}
