package hlwang.github.com.githubandroid.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hlwang.github.com.githubandroid.di.ApplicationContext;

/**
 * Created by wanghailu on 17-11-1.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides @ApplicationContext
    Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
}
