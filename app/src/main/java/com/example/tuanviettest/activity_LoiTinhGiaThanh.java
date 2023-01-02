package com.example.tuanviettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class activity_LoiTinhGiaThanh extends AppCompatActivity {
    // List các chinh nhánh
    Spinner spinner;
    SpinnerChiNhanh spinnerChiNhanh;

    Button btnKiemTra, btnXuLy;
    TextView txtPer, txtSite, txtDate, txtUser;
    ConnectSQLServer connectSQLServer = new ConnectSQLServer(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loi_tinh_gia_thanh);

        AnhXa();
        // lấy adapter từ class
        spinnerChiNhanh = new SpinnerChiNhanh(this);
        spinner.setAdapter(spinnerChiNhanh.spinnerAdapter);
        // tạo sự kiện khi chọn item
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Sự kiện khi click Kiểm tra
                btnKiemTra.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // call function từ class connectSQLServer
                        // lấy branch từ spinnerChiNhanh để truyền vào xác định db
                        connectSQLServer.GetCheckKho(spinnerChiNhanh.list.get(i));
                        // set dữ liệu
                        txtPer.setText(connectSQLServer.Per);
                        txtSite.setText(connectSQLServer.Site);
                        txtDate.setText(connectSQLServer.Date);
                        txtUser.setText(connectSQLServer.User);
                    }
                });
                //bắt sự kiện xử lý tính giá thành
                btnXuLy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        connectSQLServer.XuLyLoiKho(spinnerChiNhanh.list.get(i));
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void AnhXa() {
        btnKiemTra = (Button) findViewById(R.id.buttonKiemTraKho);
        btnXuLy = (Button) findViewById(R.id.buttonXuLyKho);
        txtSite = (TextView) findViewById(R.id.textViewSiteIDKho);
        txtPer = (TextView) findViewById(R.id.textViewPernbrKho);
        txtDate = (TextView) findViewById(R.id.textViewDateKho);
        txtUser = (TextView) findViewById(R.id.textViewUserKho);
        // add dữ liệu vào list
        spinner = (Spinner) findViewById(R.id.spinnerGiaThanh);
    }
}