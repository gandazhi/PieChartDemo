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
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/12/2.
 */

public class PieFragment extends Fragment implements OnChartValueSelectedListener {

    private static final String DATA_KEY = "PieFragment_key";
    private MonthBean mData;
    private PieChart mChart;

    public static PieFragment newInstance(MonthBean data) {

        Bundle args = new Bundle();

        args.putParcelable(DATA_KEY,data);

        PieFragment fragment = new PieFragment();
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
        mChart.getLegend().setEnabled(true);//不显示下面的标识

        //Description设置为空
        Description description = new Description();
        description.setText("");
        mChart.setDescription(description);
        //设置不许旋转
        mChart.setRotationEnabled(false);
        mChart.setOnChartValueSelectedListener(this);
        return inflate;
    }

    private void initView() {
        setData();
    }

    private void setData() {
        List<String> titles = new ArrayList<>();
        List<PieEntry> entries  = new ArrayList<>();
        for (int i = 0; i < mData.getObj().size(); i++) {
            MonthBean.PieBean pieBean = mData.getObj().get(i);
            titles.add(pieBean.getTitle());
            entries.add(new PieEntry(pieBean.getValue(),titles.get(i)));
        }

        PieDataSet dataSet = new PieDataSet(entries,"hello");
        dataSet.setColors(new int[]{Color.rgb(216, 77, 719), Color.rgb(183, 56, 63), Color.rgb(247, 85, 47)});
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setValueTextSize(15);

        PieData pieData = new PieData(dataSet);
        mChart.setData(pieData);

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) { //点击条目显示具体数据的时候调用

        int proportion = 360 / mData.getSum();
        int angle = 90 - mData.getObj().get((int) h.getX()).getValue() / 2 * proportion - mData.getSum((int) h.getX()) * proportion;
        mChart.setRotationAngle(angle);

    }

    @Override
    public void onNothingSelected() { //点击其他的地方，不显示具体数据的时候调用
        
    }
}
