package com.example.tuanviettest;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class SpinnerChiNhanh{
    List<String> list;
    //Lấy layout từ nơi call
    Context context;
    //Call spinnerAdapter để gán cho setAdapter
    ArrayAdapter spinnerAdapter;

    public SpinnerChiNhanh(Context context) {
        this.context = context;

        list = new ArrayList<>();
        list.add("Test");
        list.add("BDINH");
        list.add("DNANG");
        list.add("HTINH");
        list.add("HUE");
        list.add("KHHOA");
        list.add("NGAN1");
        list.add("NGAN2");
        list.add("PHYEN");
        list.add("QBINH");
        list.add("QNAM");
        list.add("QNGAI");
        list.add("QTRI");
        list.add("THOA1");

        spinnerAdapter = new ArrayAdapter(context,R.layout.adapter_sniper,list);
    }

}
