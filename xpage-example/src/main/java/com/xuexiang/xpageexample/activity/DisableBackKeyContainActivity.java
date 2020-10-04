package com.xuexiang.xpageexample.activity;

import android.os.Bundle;
import android.view.KeyEvent;

import com.xuexiang.xpage.base.XPageActivity;
import com.xuexiang.xpageexample.utils.XToastUtils;
import com.xuexiang.xui.utils.KeyboardUtils;

/**
 * 自定义的容器Activity
 *
 * @author xuexiang
 * @since 2019-05-19 22:28
 */
public class DisableBackKeyContainActivity extends XPageActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XToastUtils.toast("这里使用的是自定义容器Activity");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 禁止返回键
        return KeyboardUtils.onDisableBackKeyDown(keyCode) && super.onKeyDown(keyCode, event);
    }
}
