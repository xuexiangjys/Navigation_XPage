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

import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.core.PageOption;
import com.xuexiang.xpageexample.activity.DisableBackKeyContainActivity;
import com.xuexiang.xpageexample.core.BaseSimpleListFragment;

import java.util.List;

/**
 * @author xuexiang
 * @since 2020/10/3 5:52 PM
 */
@Page(name = "进阶使用")
public class AdvancedFragment extends BaseSimpleListFragment {

    @Override
    protected List<String> initSimpleData(List<String> lists) {
        lists.add("打开新的Activity");
        lists.add("使用自定义的容器打开新的Activity");
        lists.add("打开新的Activity，并且不加入返回堆栈，适合某些只能一步到头的业务");
        return lists;
    }

    @Override
    protected void onItemClick(int position) {
        switch (position) {
            case 0:
                // 当需要不影响当前Activity时，可以开启一个新的Activity。
                openNewPage(TestFragment.class);
                break;
            case 1:
                // 当你需要容器Activity具有某种特性时，可以自定义一个新的Activity作为容器，直接继承XPageActivity即可
                PageOption.to(TestFragment.class)
                        .setNewActivity(true, DisableBackKeyContainActivity.class)
                        .open(this);
                break;
            case 2:
                // 不仅可以传类名，还可以传标记符
                PageOption.to("StepFragment")
                        // 不加入堆栈中，即使用popToBack();无法返回上一个页面，适合某些只能一步到头的业务。
                        .setAddToBackStack(false)
                        .setNewActivity(true, DisableBackKeyContainActivity.class)
                        .open(this);
                break;
            default:
                break;
        }
    }
}
