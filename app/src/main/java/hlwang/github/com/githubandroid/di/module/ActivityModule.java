package hlwang.github.com.githubandroid.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import hlwang.github.com.githubandroid.di.ActivityContext;

/**
 * Created by wanghailu on 17-11-1.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    public ActivityModule(Fragment fragment){
        mActivity = fragment.getActivity();
    }

    @Provides
    Activity provideActivity(){
        return mActivity;
    }

    @ActivityContext
    @Provides
    Context provideContext(){
        return mActivity;
    }

}
