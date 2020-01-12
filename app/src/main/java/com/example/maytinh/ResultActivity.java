package com.example.maytinh;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        textView = findViewById(R.id.txt_result);
        Intent intent = getIntent();
        String result =  intent.getStringExtra(MainActivity.RESULT);

        textView.setText("Kết quả: "+result);
    }
}
