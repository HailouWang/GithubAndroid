package hlwang.github.com.githubandroid.ui.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hlwang.github.com.githubandroid.GithubAndroidApplication;
import hlwang.github.com.githubandroid.R;
import hlwang.github.com.githubandroid.di.component.ActivityComponent;
import hlwang.github.com.githubandroid.di.component.DaggerActivityComponent;
import hlwang.github.com.githubandroid.di.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public ActivityComponent getActivityComponent(){
        if(mActivityComponent == null){
            mActivityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(GithubAndroidApplication.getApplication().getComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return mActivityComponent;
    }
}
