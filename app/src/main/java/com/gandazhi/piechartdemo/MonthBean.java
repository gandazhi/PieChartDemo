package com.gandazhi.piechartdemo;

import java.util.ArrayList;

/**
 * Created by admin on 2016/12/2.
 */
public class MonthBean {

    private String date;
    private ArrayList<PieBean> obj;

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

    class PieBean{

        private String title;
        private String value;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
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
