package hlwang.github.com.githubandroid.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by wanghailu on 17-11-1.
 */
@Qualifier
//注解需要在源文件和jvm加载时，都存在
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {
}
