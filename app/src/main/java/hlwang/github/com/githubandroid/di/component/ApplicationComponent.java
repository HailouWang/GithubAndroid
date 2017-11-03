package hlwang.github.com.githubandroid.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import hlwang.github.com.githubandroid.di.ApplicationContext;
import hlwang.github.com.githubandroid.di.module.ApplicationModule;

/**
 * Created by wanghailu on 17-11-1.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ApplicationContext
    Context applicationContext();
}
