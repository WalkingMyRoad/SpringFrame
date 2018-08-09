package ist.com.springframelibrary.activity;

import android.annotation.SuppressLint;
import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by minyuchun on 2017/11/14.
 * Activity 程序中的activity管理类
 * http://www.android-doc.com/reference/java/util/LinkedList.html
 */

public final class CActivity {
    /***
     * Activity 最大个数限制，多余则清楚最先进入的 activity
     */
    private static int listSize = 4;

    /**
     * 全局的所有 Activity 集合
     */
    //请注意分析 Vector,ArrayList,CopyOnWriteArrayList,LinkedList 的区别，
    //因为这个类中我们可能对已有的数据进行删除，并且多线程访问的情况少，所以使用LinkedList 合适
    private static LinkedList<Activity> sActivityList = new LinkedList<>();


    /**构造函数*/
    @SuppressLint("StaticFieldLeak")
    private CActivity(){
        throw new UnsupportedOperationException("U can't instantiate CActivity");//不能实例化管理类
    }

    /**
     * 在链表的结尾处添加加activity；
     * @param activity 需要增加的activity
     * @return 返回是否添加成功
     */
    public static boolean add(Activity activity){
        if (sActivityList.size() >= listSize){
            sActivityList.removeFirst();
        }
        return sActivityList.add(activity);
    }

    /**
     * 修改链表顺序
     * @param activity 重新唤醒的activity
     * @return 更改成功
     */
    public static boolean resume(Activity activity){
        if (sActivityList.contains(activity) && sActivityList.getLast() != activity){
            sActivityList.remove(activity);
            return sActivityList.add(activity);
        }
        return false;
    }

    /**
     * 删除需要删除的activity
     * @param activity 需要删除的activity
     * @return 返回是否删除成功
     */
    public static boolean remove(Activity activity){
         return sActivityList.remove(activity);
    }

    /**
     * 获取已经存在的activity列表
     * @return 列表返回
     */
    public static List<Activity> getActivityList() {
        return sActivityList;
    }

    /**
     * 关闭所有的 Activity 页面
     */
    public static void finishAll(){
        for (Activity activity : sActivityList){
            activity.finish();
        }
    }

    /**
     * 获取当前展示的最上层activity
     * @return 返回最上层的activity
     */
    public static Activity getTopActivity() {
        if(sActivityList != null && sActivityList.size()>0) return sActivityList.getLast();
        return null;
    }

}
