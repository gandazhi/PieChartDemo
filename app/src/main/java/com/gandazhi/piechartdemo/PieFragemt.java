package com.gandazhi.piechartdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by admin on 2016/12/2.
 */

public class PieFragemt extends Fragment {

    private static final String DATA_KEY = "PieFragment_key";
    private String mData;

    public static PieFragemt newInstance(String data) {

        Bundle args = new Bundle();

        args.putString(DATA_KEY,data);
        PieFragemt fragment = new PieFragemt();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle =getArguments();
        if (bundle != null) {
            mData = bundle.getString(DATA_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { //返回显示的view

        TextView textView = new TextView(getContext());
        textView.setText(mData);

        return textView;
    }
}
