package ist.com.springframe.fragment;

import android.os.Handler;
import android.support.annotation.NonNull;


/**
 * Created by minyuchun on 2017/11/23.
 * 2 you should create this c;ass implements xxxxTasksContract.Presenter
 */

class DemoTaskPresenter implements DemoTasksContract.Presenter{
    // 6 override the constructor and set the value to mView;
    private DemoTasksContract.View mView;

    public DemoTaskPresenter(@NonNull DemoTasksContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

}
