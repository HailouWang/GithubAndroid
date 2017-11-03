package hlwang.github.com.githubandroid.contract;

import hlwang.github.com.githubandroid.AbstractPresenter;
import hlwang.github.com.githubandroid.BaseView;

/**
 * Created by wanghailu on 17-11-3.
 */

public interface MainContract {
    interface View extends BaseView{
        void finishActivity();
    }

    abstract class Presenter extends AbstractPresenter<View>{
        public abstract void onBackPressed();
    }
}
