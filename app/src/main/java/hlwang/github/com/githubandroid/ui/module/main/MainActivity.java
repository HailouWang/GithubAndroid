package hlwang.github.com.githubandroid.ui.module.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import hlwang.github.com.githubandroid.GithubAndroidApplication;
import hlwang.github.com.githubandroid.R;
import hlwang.github.com.githubandroid.di.HasComponent;
import hlwang.github.com.githubandroid.di.component.ApplicationComponent;
import hlwang.github.com.githubandroid.di.component.DaggerMainComponent;
import hlwang.github.com.githubandroid.di.component.MainComponent;
import hlwang.github.com.githubandroid.di.module.ActivityModule;
import hlwang.github.com.githubandroid.presenter.MainPresenter;
import hlwang.github.com.githubandroid.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent> {

    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public MainComponent getComponent() {
        return DaggerMainComponent.builder()
                .applicationComponent(GithubAndroidApplication.getApplication().getComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }
}
