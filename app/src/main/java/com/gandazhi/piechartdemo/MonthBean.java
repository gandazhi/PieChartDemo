package com.gandazhi.piechartdemo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by admin on 2016/12/2.
 */
public class MonthBean implements Parcelable{

    private String date;
    private ArrayList<PieBean> obj;


    public MonthBean(Parcel in){
        date = in.readString();
    }

    public static final Creator<MonthBean> CREATOR = new Creator<MonthBean>() {
        @Override
        public MonthBean createFromParcel(Parcel parcel) {
            return new MonthBean(parcel);
        }

        @Override
        public MonthBean[] newArray(int i) {
            return new MonthBean[0];
        }
    };
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<PieBean> getObj() {
        return obj;
    }

    public void setObj(ArrayList<PieBean> obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "MonthBean{" +
                "date='" + date + '\'' +
                ", obj=" + obj.toString() +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
    }

    public int getSum() {
        int sum = 0;
        for (PieBean pieBean : obj){
            sum += pieBean.getValue();
        }
        return sum;
    }

    public int getSum(int index) {
        int sum = 0;
        for (int i = 0; i < index; i++){
            sum +=  obj.get(i).getValue();
        }
        return sum;
    }

    class PieBean{

        private String title;
        private int value;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "PieBean{" +
                    "title='" + title + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
