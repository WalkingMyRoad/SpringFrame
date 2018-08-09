package ist.com.springframe.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import ist.com.springframe.R;
import ist.com.springframelibrary.fragment.BFragment;


/**
 * Created by minyuchun on 2017/11/22.
 * 3 you should create this class extend BFragment<from 1.class presenter> and implements class view from 1.class view
 */

public class DemoFragment extends BFragment<DemoTasksContract.Presenter> implements DemoTasksContract.View{

    /**
     * 4 you should make this function that can new a instance
     * 获取实例
     * @param data 接口数据
     * @return 实例
     */
    public static DemoFragment newInstance(Parcelable data) {
        Bundle arguments = new Bundle();
        arguments.putParcelable(DemoFragment.class.getName(),data);
        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void setPresenter(DemoTasksContract.Presenter presenter) {
        /// 7. you should set the value to mPresenter that we can access the functions in Presenter
        if (mPresenter == null)
            mPresenter = new DemoTaskPresenter(this);
    }

    @Override
    protected int addFragmentLayout() {
        //5. you should create layout_xml add change 0;
        return R.layout.fragment_demo;
    }

    @Override
    protected void initView(View view) {

    }
}
