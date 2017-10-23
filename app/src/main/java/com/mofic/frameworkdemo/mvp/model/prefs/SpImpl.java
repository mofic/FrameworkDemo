package com.mofic.frameworkdemo.mvp.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.mofic.frameworkdemo.app.App;
import com.mofic.frameworkdemo.app.Constants;

import java.util.Map;
import java.util.Set;

/**
 * @author lanweining
 * @date 2017/10/22
 */

public class SpImpl implements SpHelper {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SpImpl() {
        this(Constants.PACKAGE_NAME);
    }

    public SpImpl(String spName) {
        preferences = App.getInstance().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    /**
     * 向SP存入指定key对应的数据
     * 其中value可以是String、boolean、float、int、long等各种基本类型的值
     */
    @Override
    public SharedPreferences.Editor putString(String key, @Nullable String value) {
        editor.putString(key, value);
        return editor;
    }

    @Override
    public SharedPreferences.Editor putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        return editor;
    }

    @Override
    public SharedPreferences.Editor putFloat(String key, float value) {
        editor.putFloat(key, value);
        return editor;
    }

    @Override
    public SharedPreferences.Editor putInt(String key, int value) {
        editor.putInt(key, value);
        return editor;
    }

    @Override
    public SharedPreferences.Editor putLong(String key, long value) {
        editor.putLong(key, value);
        return editor;
    }

    @Override
    public SharedPreferences.Editor putStringSet(String key, @Nullable Set<String> values) {
        editor.putStringSet(key, values);
        return editor;
    }

    /**
     * 删除SP里指定key对应的数据项
     */
    @Override
    public SharedPreferences.Editor remove(String key) {
        editor.remove(key);
        return editor;
    }

    /**
     * 提交数据
     */
    @Override
    public void apply() {
        editor.apply();
    }

    /**
     * 清空SP里所以数据
     */
    @Override
    public void clear() {
        editor.clear();
        editor.apply();
    }

    /**
     * 获取SP数据里指定key对应的value。如果key不存在，则返回默认值defValue。
     */
    @Override
    public String getString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    @Override
    public float getFloat(String key, float defValue) {
        return preferences.getFloat(key, defValue);
    }

    @Override
    public int getInt(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    @Override
    public long getLong(String key, long defValue) {
        return preferences.getLong(key, defValue);
    }

    @Override
    public Set<String> getStringSet(String key, Set<String> defValues) {
        return preferences.getStringSet(key, defValues);
    }

    @Override
    public Map<String, ?> getAll() {
        return preferences.getAll();
    }

    /**
     * 判断SP是否包含特定key的数据
     */
    @Override
    public boolean contains(String key) {
        return preferences.contains(key);
    }

}