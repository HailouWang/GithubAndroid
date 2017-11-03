package hlwang.github.com.githubandroid.presenter;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

import hlwang.github.com.githubandroid.R;
import hlwang.github.com.githubandroid.contract.MainContract;
import hlwang.github.com.githubandroid.di.ActivityContext;

/**
 * Created by wanghailu on 17-11-3.
 */

public class MainPresenter extends MainContract.Presenter {
    private Context mContext;
    private long mLastClickBackTime = 0;

    public MainPresenter(Context context){
        mContext = context;
    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - mLastClickBackTime < 1000){
            mView.finishActivity();
        }else{
            mLastClickBackTime = System.currentTimeMillis();
            Toast.makeText(mContext, R.string.click_again_exit, Toast.LENGTH_SHORT).show();
        }
    }
}
