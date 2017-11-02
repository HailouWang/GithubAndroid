package hlwang.github.com.githubandroid.di.component;

import dagger.Component;
import hlwang.github.com.githubandroid.di.PerActivity;
import hlwang.github.com.githubandroid.di.module.ActivityModule;
import hlwang.github.com.githubandroid.ui.module.BlogRecommendFragment;
import hlwang.github.com.githubandroid.ui.module.frame.FrameRecommendFragment;

/**
 * Created by wanghailu on 17-11-1.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
modules = {ActivityModule.class})
public interface MainComponent extends ActivityComponent{
    void inject(FrameRecommendFragment frameRecommendFragment);

    void inject(BlogRecommendFragment blogRecommendFragment);
}
