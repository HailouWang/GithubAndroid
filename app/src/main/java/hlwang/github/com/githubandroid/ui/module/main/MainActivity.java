package hlwang.github.com.githubandroid.ui.module.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlwang.github.com.githubandroid.GithubAndroidApplication;
import hlwang.github.com.githubandroid.R;
import hlwang.github.com.githubandroid.di.HasComponent;
import hlwang.github.com.githubandroid.di.component.DaggerMainComponent;
import hlwang.github.com.githubandroid.di.component.MainComponent;
import hlwang.github.com.githubandroid.di.module.ActivityModule;
import hlwang.github.com.githubandroid.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent> {
    @BindView(R.id.toolbar)
    private Toolbar mToolBar;

    @BindView(R.id.content_frame)
    FrameLayout mContentFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews(){
        setSupportActionBar(mToolBar);
    }

    @Override
    public MainComponent getComponent() {
        return DaggerMainComponent.builder()
                .applicationComponent(GithubAndroidApplication.getApplication().getComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }
}
