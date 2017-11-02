package hlwang.github.com.githubandroid.ui.module.main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlwang.github.com.githubandroid.GithubAndroidApplication;
import hlwang.github.com.githubandroid.R;
import hlwang.github.com.githubandroid.di.HasComponent;
import hlwang.github.com.githubandroid.di.component.DaggerMainComponent;
import hlwang.github.com.githubandroid.di.component.MainComponent;
import hlwang.github.com.githubandroid.di.module.ActivityModule;
import hlwang.github.com.githubandroid.ui.base.BaseActivity;
import hlwang.github.com.githubandroid.ui.module.blog.BlogRecommendFragment;
import hlwang.github.com.githubandroid.ui.module.frame.FrameRecommendFragment;
import hlwang.github.com.githubandroid.ui.module.profile.AppSettingsFragment;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent> {
    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @BindView(R.id.content_frame)
    FrameLayout mContentFrame;

    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        setSupportActionBar(mToolBar);

        mBottomBar.setOnTabSelectListener(mOnTabSelectListener);
    }

    private OnTabSelectListener mOnTabSelectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelected(@IdRes int tabId) {
            changeTitle(tabId);
            String fragmentName = getFragmentName(tabId);
            switchFragment(fragmentName);
        }
    };

    private void changeTitle(int tabId) {
        switch (tabId) {
            case R.id.tab_frames:
                setTitle(R.string.main_tab_frames);
                break;
            case R.id.tab_blogs:
                setTitle(R.string.main_tab_blogs);
                break;
            case R.id.tab_settings:
                setTitle(R.string.main_tab_settings);
                break;
            default:
                break;
        }
    }

    private String getFragmentName(int tabId) {
        switch (tabId) {
            case R.id.tab_frames:
                return FrameRecommendFragment.class.getName();
            case R.id.tab_blogs:
                return BlogRecommendFragment.class.getName();
            case R.id.tab_settings:
                return AppSettingsFragment.class.getName();
            default:
                return null;
        }
    }

    private void switchFragment(String fragmentName) {
        Fragment fragment = mFragmentManager.findFragmentByTag(fragmentName);

        if (fragment != null) {
            if (mCurrentFragment == fragment) {
                return;
            }
            mFragmentManager.beginTransaction().show(fragment).commit();
        } else {
            fragment = Fragment.instantiate(this, fragmentName);
            mFragmentManager.beginTransaction().add(fragment, fragmentName).commit();
        }

        if (mCurrentFragment != null) {
            mFragmentManager.beginTransaction().hide(mCurrentFragment).commit();
        }

        mCurrentFragment = fragment;
    }

    @Override
    public MainComponent getComponent() {
        return DaggerMainComponent.builder()
                .applicationComponent(GithubAndroidApplication.getApplication().getComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }
}
