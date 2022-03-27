package com.jaguarteam.fakebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Refresh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
    }

    @Override
    protected void onStart() {
        super.onStart();
        finish();
    }
}