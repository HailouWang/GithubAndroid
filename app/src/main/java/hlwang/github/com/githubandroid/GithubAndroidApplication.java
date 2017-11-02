package hlwang.github.com.githubandroid;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import hlwang.github.com.githubandroid.constants.Tags;
import hlwang.github.com.githubandroid.di.HasComponent;
import hlwang.github.com.githubandroid.di.component.ApplicationComponent;
import hlwang.github.com.githubandroid.di.component.DaggerActivityComponent;
import hlwang.github.com.githubandroid.di.component.DaggerApplicationComponent;
import hlwang.github.com.githubandroid.di.module.ApplicationModule;
import hlwang.github.com.githubandroid.utils.MainConfig;

/**
 * Created by wanghailu on 17-11-1.
 */

public class GithubAndroidApplication extends MultiDexApplication {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = this;

        //初始化Logger
        Logger.t(Tags.TAG_MAIN);
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return MainConfig.LOCAL_LOGD;
            }
        });
    }

    public static GithubAndroidApplication getApplication(){
        return (GithubAndroidApplication) sContext;
    }

    ApplicationComponent mApplicationComponent;

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }
}
