package com.gandazhi.piechartdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp_main;
    private String mJson = "[{\"date\":\"2016年5月\",\"obj\":[{\"title\":\"外卖\",\"value\":34},{\"title\":\"娱乐\",\"value\":21},{\"title\":\"其他\",\"value\":45}]},{\"date\":\"2016年6月\",\"obj\":[{\"title\":\"外卖\",\"value\":32},{\"title\":\"娱乐\",\"value\":22},{\"title\":\"其他\",\"value\":42}]}]";
    private ArrayList<MonthBean> mData;
    private Button btn_last;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp_main = ((ViewPager) findViewById(R.id.vp_main));
        btn_last = ((Button) findViewById(R.id.btn_last));
        btn_next = ((Button) findViewById(R.id.btn_next));

        initData();
        initView();

        btn_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "this last", Toast.LENGTH_LONG).show();
                if (vp_main.getCurrentItem() != 0)
                    vp_main.setCurrentItem(vp_main.getCurrentItem() - 1);
                update_btnText();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "this next", Toast.LENGTH_LONG).show();
                if (vp_main.getCurrentItem() != vp_main.getAdapter().getCount() - 1)
                    vp_main.setCurrentItem(vp_main.getCurrentItem() + 1);
                update_btnText();
            }
        });

        vp_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {//ViewPager被选中的时候
                update_btnText();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void update_btnText() {
        if (vp_main.getCurrentItem() != vp_main.getAdapter().getCount() - 1) {
            btn_next.setText(mData.get(vp_main.getCurrentItem() + 1).getDate());
        } else {
            btn_next.setText("没有了");
        }
        if (vp_main.getCurrentItem() != 0) {
            btn_last.setText(mData.get(vp_main.getCurrentItem() - 1).getDate());
        } else {
            btn_last.setText("没有了");
        }
    }


    private void initData() {
        Gson gson = new Gson();
        mData = gson.fromJson(mJson, new TypeToken<ArrayList<MonthBean>>() {
        }.getType()); //解析JSON
    }

    private void initView() {
        vp_main.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return PieFragment.newInstance(mData.get(position)); //返回要显示的fragment
            }

            @Override
            public int getCount() {
                return mData.size(); //返回一共有多少页
            }
        });

        update_btnText();
    }

}
