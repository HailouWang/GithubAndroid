package hlwang.github.com.githubandroid.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by wanghailu on 17-11-1.
 * 范围限定注解，允许对象的生命周期跟随需要注入的目标Activity的生命周期
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
