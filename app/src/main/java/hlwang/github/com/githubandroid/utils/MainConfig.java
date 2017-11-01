package hlwang.github.com.githubandroid.utils;

import android.os.Build;
import android.util.Log;

/**
 * Created by wanghailu on 17-11-1.
 */

public class MainConfig {
    private static final String LOGABLE_TAG = "com_github_hlwang_debug";
    public static boolean LOCAL_LOGD;

    static {
        LOCAL_LOGD = !"user".equals(Build.TYPE) ||
                Log.isLoggable(LOGABLE_TAG, Log.VERBOSE);
    }
}
