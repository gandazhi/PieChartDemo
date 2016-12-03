package com.gandazhi.piechartdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp_main;
    private String mJson = "[{\"date\":\"2016年5月\",\"obj\":[{\"title\":\"外卖\",\"value\":34},{\"title\":\"娱乐\",\"value\":21},{\"title\":\"其他\",\"value\":45}]},{\"date\":\"2016年6月\",\"obj\":[{\"title\":\"外卖\",\"value\":32},{\"title\":\"娱乐\",\"value\":22},{\"title\":\"其他\",\"value\":42}]}]";
    private ArrayList<MonthBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp_main = ((ViewPager) findViewById(R.id.vp_main));

        initData();
        initView();
    }

    private void initData() {
        Gson gson = new Gson();
        mData = gson.fromJson(mJson, new TypeToken<ArrayList<MonthBean>>(){}.getType()); //解析JSON
    }

    private void initView() {
        vp_main.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return PieFragemt.newInstance(mData.get(position)); //返回要显示的fragment
            }

            @Override
            public int getCount() {
                return mData.size(); //返回一共有多少页
            }
        });
    }
}
