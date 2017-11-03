package hlwang.github.com.githubandroid.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import hlwang.github.com.githubandroid.di.ActivityContext;
import hlwang.github.com.githubandroid.di.PerActivity;
import hlwang.github.com.githubandroid.presenter.MainPresenter;

/**
 * Created by wanghailu on 17-11-1.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    @Provides @PerActivity
    Activity provideActivity(){
        return mActivity;
    }

    @Provides @ActivityContext
    Context provideContext(){
        return mActivity;
    }

    @Provides
    MainPresenter provideMainPresenter(){
        return new MainPresenter(mActivity);
    }

}
