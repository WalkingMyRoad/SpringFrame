package ist.com.springframelibrary.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by minyuchun on 2018/4/27.
 * 碎片控制类
 */

public class CFragment {
    /**fragment maxSize limit，if you exceed it the system will clear by itself*/
    private static int listSize = 8;
    /**save all fragment*/
    private static LinkedList<Fragment> sFragments = new LinkedList<>();

    /**构造函数*/
    @SuppressLint("StaticFieldLeak")
    private CFragment(){
        throw new UnsupportedOperationException("U can't instantiate CFragment");//不能实例化管理类
    }

    /**
     * 在链表的结尾处添加加fragment；
     * @param fragment 需要增加的fragment
     * @return 返回是否添加成功
     */
    public static boolean add(Fragment fragment){
        if (sFragments.size() >= listSize){
            sFragments.removeFirst();
        }
        return sFragments.add(fragment);
    }

    /**
     * change the order in linkedList
     * @param fragment resume fragment
     * @return if succeed
     */
    public static boolean resume(Fragment fragment){
        if (sFragments.contains(fragment) && sFragments.getLast() != fragment){
            sFragments.remove(fragment);
            return sFragments.add(fragment);
        }
        return false;
    }

    /**
     * 删除需要删除的fragment
     * @param fragment 需要删除的fragment
     * @return 返回是否删除成功
     */
    public static boolean remove(Fragment fragment){
        return sFragments.remove(fragment);
    }

    /**
     * 获取已经存在的activity列表
     * @return 列表返回
     */
    public static List<Fragment> getFragmentList() {
        return sFragments;
    }

    /**
     * 获取顶层的Fragment
     * @return 返回顶层的Fragment
     */
    public static Fragment getTopFragment(){
        return sFragments.getLast();
    }
}
