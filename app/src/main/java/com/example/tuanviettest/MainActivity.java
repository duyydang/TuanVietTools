package com.example.tuanviettest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnMoTrangThai,btnTinhKho,btnLoiCapNhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        btnMoTrangThai.setEnabled(false);
        btnMoTrangThai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,activity_MoTrangThaiDonHang.class);
                startActivity(intent);
            }
        });
        btnTinhKho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_LoiTinhGiaThanh.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        btnMoTrangThai = (Button) findViewById(R.id.buttonMoTrangThaiDonHang);
        btnLoiCapNhat = (Button) findViewById(R.id.buttonLoiCapNhat);
        btnTinhKho = (Button) findViewById(R.id.buttonTinhSoLieuKho);
    }

}