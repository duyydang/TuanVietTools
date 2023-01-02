package com.example.tuanviettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    ConnectSQLServer connectSQLServer = new ConnectSQLServer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loi_tinh_gia_thanh);

        AnhXa();
        spinnerChiNhanh = new SpinnerChiNhanh(this);
        spinner.setAdapter(spinnerChiNhanh.spinnerAdapter);

        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectSQLServer.connectionclass();
                connectSQLServer.GetCheckKho();
                txtPer.setText(connectSQLServer.Per);
                txtSite.setText(connectSQLServer.Site);
                txtDate.setText(connectSQLServer.Date);
                txtUser.setText(connectSQLServer.User);
            }
        });
        btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectSQLServer.connectionclass();
                connectSQLServer.XuLyLoiKho();
                    Toast.makeText(activity_LoiTinhGiaThanh.this, "Xử lý thành công", Toast.LENGTH_SHORT).show();
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
        spinner = (Spinner)findViewById(R.id.spinnerGiaThanh);
    }
}