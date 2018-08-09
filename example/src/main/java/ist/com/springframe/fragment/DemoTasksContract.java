package ist.com.springframe.fragment;
import ist.com.springframelibrary.fragment.BFragmentPresenter;
import ist.com.springframelibrary.fragment.BFragmentView;

/**
 * Created by minyuchun on 2017/11/22.
 * 1.first you shoule create this class to make interface extend BFragmentView and BFragmentPresenter
 */

public interface DemoTasksContract {

    interface View extends BFragmentView<Presenter> {

    }

    interface Presenter extends BFragmentPresenter {

    }
}
