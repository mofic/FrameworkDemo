package com.mofic.frameworkdemo.mvp.model.prefs;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * @author lanweining
 * @date 2017/10/22
 */

public interface SpHelper {

    /**
     * 向SP存入指定key对应的数据
     * 其中value可以是String、boolean、float、int、long等各种基本类型的值
     */
    SharedPreferences.Editor putString(String key, @Nullable String value);

    SharedPreferences.Editor putBoolean(String key, boolean value);

    SharedPreferences.Editor putFloat(String key, float value);

    SharedPreferences.Editor putInt(String key, int value);

    SharedPreferences.Editor putLong(String key, long value);

    SharedPreferences.Editor putStringSet(String key, @Nullable Set<String> values);

    /**
     * 删除SP里指定key对应的数据项
     */
    SharedPreferences.Editor remove(String key);

    /**
     * 提交数据
     */
    void apply();

    /**
     * 清空SP里所以数据
     */
    void clear();

    /**
     * 获取SP数据里指定key对应的value。如果key不存在，则返回默认值defValue。
     */
    String getString(String key, String defValue);

    boolean getBoolean(String key, boolean defValue);

    float getFloat(String key, float defValue);

    int getInt(String key, int defValue);

    long getLong(String key, long defValue);

    Set<String> getStringSet(String key, Set<String> defValues);

    Map<String, ?> getAll();

    /**
     * 判断SP是否包含特定key的数据
     */
    boolean contains(String key);

}
