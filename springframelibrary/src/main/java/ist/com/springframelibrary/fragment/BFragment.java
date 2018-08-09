package ist.com.springframelibrary.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by minyuchun on 2018/3/23.
 * Fragment 基类
 */

public abstract class BFragment<T extends BFragmentPresenter> extends Fragment implements BFragmentView<T>{

    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CFragment.add(this);
        setPresenter(mPresenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (addFragmentLayout()>0){
            View view = inflater.inflate(addFragmentLayout(), container, false);
            initView(view);
            return view;
        } else
            throw new NullPointerException("please add Fragment view");
    }

    @Override
    public void onResume() {
        super.onResume();
        CFragment.resume(this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        CFragment.remove(this);
    }
    /***
     * add Fragment view id
     * @return fragment view id
     */
    protected abstract int addFragmentLayout();
    /**
     * init view
     */
    protected abstract void initView(View view);
}
