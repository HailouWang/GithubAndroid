package hlwang.github.com.githubandroid;

/**
 * Created by wanghailu on 17-11-3.
 */

public interface BasePresenter<T extends BaseView> {
    void attach(T view);

    void detach();
}
