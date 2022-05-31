package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

public class FivethActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView1(this));
    }
}
