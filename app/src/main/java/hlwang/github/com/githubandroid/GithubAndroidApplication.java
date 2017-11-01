package hlwang.github.com.githubandroid;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import hlwang.github.com.githubandroid.constants.Tags;
import hlwang.github.com.githubandroid.utils.MainConfig;

/**
 * Created by wanghailu on 17-11-1.
 */

public class GithubAndroidApplication extends Application {

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

    public static Context getContext(){
        return sContext;
    }
}
