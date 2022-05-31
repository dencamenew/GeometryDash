package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }

    public void Click(View view) {

        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);

            case R.id.button1:
                intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(SecondActivity.this, FourthActivity.class);
                startActivity(intent);
                break;
        }
    }
}
