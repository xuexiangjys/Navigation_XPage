/*
 * Copyright (C) 2020 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.xpageexample.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpageexample.R;
import com.xuexiang.xpageexample.core.BaseFragment;
import com.xuexiang.xrouter.annotation.AutoWired;
import com.xuexiang.xrouter.launcher.XRouter;
import com.xuexiang.xutil.common.StringUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xuexiang
 * @since 2020/10/3 5:12 PM
 */
@Page(name = "测试页面")
public class TestFragment extends BaseFragment {

    public final static String KEY_IS_NEED_BACK = "is_need_back";
    public final static String KEY_EVENT_NAME = "event_name";
    public final static String KEY_EVENT_DATA = "event_data";
    public final static String KEY_BACK_DATA = "back_data";

    @BindView(R.id.tv_display)
    TextView mTvDisplay;
    @BindView(R.id.btn_back)
    Button mBtnBack;

    @AutoWired(name = KEY_IS_NEED_BACK)
    boolean isNeedBack;
    @AutoWired(name = KEY_EVENT_NAME)
    String eventName;
    @AutoWired(name = KEY_EVENT_DATA)
    String eventData;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initArgs() {
        XRouter.getInstance().inject(this);
    }

    @Override
    protected void initViews() {
        if (!StringUtils.isEmpty(eventName)) {
            mTvDisplay.setText(String.format("接收到数据\n 事件名：%s\n 事件数据：%s", eventName, eventData));
        }
        if (isNeedBack) {
            mBtnBack.setVisibility(View.VISIBLE);
        } else {
            mBtnBack.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.btn_back)
    void back(View v) {
        // 设置返回的数据，类似Activity里的setResult
        Intent intent = new Intent();
        intent.putExtra(KEY_BACK_DATA, "==【返回的数据】==");
        setFragmentResult(500, intent);
        // 返回操作
        popToBack();
    }
}
