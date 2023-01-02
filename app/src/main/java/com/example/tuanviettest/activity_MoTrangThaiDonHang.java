package com.example.tuanviettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_MoTrangThaiDonHang extends AppCompatActivity {
    // List các chinh nhánh
    Spinner spinner;
    SpinnerChiNhanh spinnerChiNhanh;

    EditText edtOrder;
    Button btnKiemTra, btnXuLy;
    TextView txtStatus, txtOrder, txtDate, txtARBatnbr;

    ConnectSQLServer connectSQLServer = new ConnectSQLServer(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_trang_thai_don_hang);

        AnhXa();
        // lấy adapter từ class
        spinnerChiNhanh = new SpinnerChiNhanh(this);
        spinner.setAdapter(spinnerChiNhanh.spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Sự kiện khi click Kiểm tra
                btnKiemTra.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String order = edtOrder.getText().toString();
                        // call function từ class connectSQLServer
                        // lấy branch từ spinnerChiNhanh để truyền vào xác định db
                        connectSQLServer.CheckOrder(spinnerChiNhanh.list.get(i),order);
                        // set dữ liệu
                        txtStatus.setText(connectSQLServer.result.getStatus());
                        txtOrder.setText(connectSQLServer.result.getOrder());
                        txtDate.setText(connectSQLServer.result.getDate());
                        txtARBatnbr.setText(connectSQLServer.result.getArbatnbr());
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
        spinner = (Spinner) findViewById(R.id.spinnerDonHang);
        btnKiemTra = (Button) findViewById(R.id.buttonCheckOrder);
        btnXuLy = (Button) findViewById(R.id.buttonXuLyOrder);
        txtStatus = (TextView) findViewById(R.id.textViewStatusOrder);
        txtOrder = (TextView) findViewById(R.id.textViewOrder);
        txtDate = (TextView) findViewById(R.id.textViewOrderDate);
        txtARBatnbr = (TextView) findViewById(R.id.textViewARBatNbr);
        edtOrder = (EditText) findViewById(R.id.editTextCheckOrder);
    }
}