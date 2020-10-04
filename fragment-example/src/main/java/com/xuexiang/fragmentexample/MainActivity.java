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

package com.xuexiang.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_first).setOnClickListener(this);
        findViewById(R.id.btn_second).setOnClickListener(this);
        findViewById(R.id.btn_test).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_first:
                toFirst();
                break;
            case R.id.btn_second:
                toSecond();
                break;
            case R.id.btn_test:
                toTest();
                break;
            default:
                break;
        }
    }

    public void toFirst() {
        FragmentTransaction transaction = getFragmentTransaction();
        transaction.replace(R.id.fl_container, FirstFragment.newInstance());
        transaction.commit();
    }

    public void toSecond() {
        FragmentTransaction transaction = getFragmentTransaction();
        transaction.replace(R.id.fl_container, SecondFragment.newInstance());
        transaction.commit();
    }

    public void toTest() {
        int id = (int) (Math.random() * 100);
        FragmentTransaction transaction = getFragmentTransaction();
        transaction.replace(R.id.fl_container, TestFragment.newInstance("事件" + id, "事件" + id + "携带的数据"));
        transaction.commit();
    }

    private FragmentTransaction getFragmentTransaction() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        return fragmentManager.beginTransaction();
    }
}
