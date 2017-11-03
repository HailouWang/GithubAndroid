package hlwang.github.com.githubandroid;

/**
 * Created by wanghailu on 17-11-3.
 */

public abstract class AbstractPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T mView;

    @Override
    public void attach(T view) {
        mView = view;
    }

    @Override
    public void detach() {
        mView = null;
    }

    protected boolean isAttached(){
        return mView != null;
    }
}
