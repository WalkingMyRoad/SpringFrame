package ist.com.springframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ist.com.springframe.fragment.DemoFragment;
import ist.com.springframelibrary.activity.BActivity;

public class MainActivity extends BActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getFragmentManager().beginTransaction()
                .replace(R.id.basic, DemoFragment.newInstance(null))
                .commit();
    }

    @Override
    protected int setLayoutView() {
        return 0;
    }

    @Override
    protected void setToolBar() {

    }

}
