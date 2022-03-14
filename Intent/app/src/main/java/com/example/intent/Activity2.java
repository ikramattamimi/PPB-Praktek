package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView nama, umur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        nama = findViewById(R.id.nama);
        umur = findViewById(R.id.umur);

        String get_nama = getIntent().getStringExtra("kirim_nama");
        String get_umur = getIntent().getStringExtra("kirim_umur");
        nama.setText(get_nama);
        umur.setText(get_umur);
    }
}