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
        list.add("Khánh Hoà");
        list.add("Phú Yên");
        list.add("Bình Định");
        list.add("Quảng Ngãi");
        list.add("Quảng Nam");
        list.add("Đà Nẵng");
        list.add("Huế");
        list.add("Quảng Trị");
        list.add("Quảng Bình");
        list.add("Hà Tĩnh");
        list.add("Vinh");
        list.add("Quỳnh Lưu");
        list.add("Thanh Hóa");

        spinnerAdapter = new ArrayAdapter(context,R.layout.adapter_sniper,list);
    }

}
