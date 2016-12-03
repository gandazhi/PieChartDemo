package com.gandazhi.piechartdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/12/2.
 */

public class PieFragemt extends Fragment {

    private static final String DATA_KEY = "PieFragment_key";
    private MonthBean mData;
    private PieChart mChart;

    public static PieFragemt newInstance(MonthBean data) {

        Bundle args = new Bundle();

        args.putParcelable(DATA_KEY,data);

        PieFragemt fragment = new PieFragemt();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取到Arguments里传入的data
        Bundle bundle =getArguments();
        if (bundle != null) {
            mData = bundle.getParcelable(DATA_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { //返回显示的view

        View inflate = inflater.inflate(R.layout.fragment_pie,null);
        mChart = (PieChart) inflate.findViewById(R.id.pc_chart);
        initView();

        return inflate;
    }

    private void initView() {
        setData();
    }

    private void setData() {
        List<String> titles = new ArrayList<>();
        List<PieEntry> entrys = new ArrayList<>();
        for (int i = 0; i < mData.getObj().size(); i++) {
            MonthBean.PieBean pieBean = mData.getObj().get(i);
            titles.add(pieBean.getTitle());
            entrys.add(new PieEntry(pieBean.getValue()));
        }

        PieDataSet dataSet = new PieDataSet(entrys,"");
        dataSet.setColors(new int[]{Color.rgb(216, 77, 719), Color.rgb(183, 56, 63), Color.rgb(247, 85, 47)});

        PieData pieData = new PieData(dataSet);
        mChart.setData(pieData);

    }
}
