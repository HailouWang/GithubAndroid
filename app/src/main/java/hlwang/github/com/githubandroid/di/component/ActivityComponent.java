package hlwang.github.com.githubandroid.di.component;

import android.app.Activity;
import android.content.Context;

import dagger.Component;
import hlwang.github.com.githubandroid.di.ActivityContext;
import hlwang.github.com.githubandroid.di.PerActivity;
import hlwang.github.com.githubandroid.di.module.ActivityModule;

/**
 * Created by wanghailu on 17-11-1.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();

    @ActivityContext
    Context context();
}
