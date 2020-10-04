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
import android.os.Bundle;

import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.core.PageOption;
import com.xuexiang.xpage.enums.CoreAnim;
import com.xuexiang.xpageexample.core.BaseSimpleListFragment;
import com.xuexiang.xpageexample.utils.XToastUtils;

import java.util.List;

/**
 * 基础使用
 *
 * @author xuexiang
 * @since 2019-07-08 00:52
 */
@Page(name = "基础使用")
public class BasicFragment extends BaseSimpleListFragment {

    private static final int REQUEST_CODE = 1000;

    @Override
    protected List<String> initSimpleData(List<String> lists) {
        lists.add("只打开页面");
        lists.add("打开页面，设置页面切换动画");
        lists.add("打开页面，传递参数，不返回结果");
        lists.add("打开页面，不传递参数，返回结果");
        return lists;
    }

    @Override
    protected void onItemClick(int position) {
        switch (position) {
            case 0:
                openPage(TestFragment.class);
                break;
            case 1:
                PageOption.to(TestFragment.class)
                        .setAnim(CoreAnim.present)
                        .open(this);
                break;
            case 2:
                int id = (int) (Math.random() * 100);
                PageOption.to(TestFragment.class)
                        .putBoolean(TestFragment.KEY_IS_NEED_BACK, false)
                        .putString(TestFragment.KEY_EVENT_NAME, "事件" + id)
                        .putString(TestFragment.KEY_EVENT_DATA, "事件" + id + "携带的数据")
                        .open(this);
                break;
            case 3:
                // openForResult 类似activity的startActivityForResult, 返回在onFragmentResult，类似onActivityResult
                PageOption.to(TestFragment.class)
                        .putBoolean(TestFragment.KEY_IS_NEED_BACK, true)
                        .openForResult(this, REQUEST_CODE);
            default:
                break;
        }
    }


    @Override
    public void onFragmentResult(int requestCode, int resultCode, Intent data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if (data != null) {
            Bundle extras = data.getExtras();
            XToastUtils.toast("requestCode:" + requestCode + " resultCode:" + resultCode + " data:" + extras.getString(TestFragment.KEY_BACK_DATA));
        }
    }
}
