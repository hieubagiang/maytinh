package com.example.maytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    EditText txt_soA, txt_soB;
    TextView txt_result;
    Button btn_cong, btn_tru, btn_chia, btn_nhan;
    ImageButton img_send, img_exit;
    public static final String RESULT = "result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_soA = findViewById(R.id.txt_soA);
        txt_soB = findViewById(R.id.txt_soB);
        txt_result = findViewById(R.id.txt_result);
        btn_cong = findViewById(R.id.btn_cong);
        btn_tru = findViewById(R.id.btn_tru);
        btn_chia = findViewById(R.id.btn_chia);
        btn_nhan = findViewById(R.id.btn_nhan);
        img_send = findViewById(R.id.img_send);
        img_exit = findViewById(R.id.img_exit);
        AtomicReference<Float> soA = new AtomicReference<>((float) 0);
        AtomicReference<Float> soB = new AtomicReference<>((float) 0);
        AtomicReference<Float> result = new AtomicReference<>((float) 0);
        txt_result.setText("Kết quả");
        btn_cong.setOnClickListener(c ->
        {
            soA.set(Float.valueOf(txt_soA.getText().toString()));
            soB.set(Float.valueOf(txt_soB.getText().toString()));
            result.set(soA.get() + soB.get());
            txt_result.setText(result.toString());
        });
        btn_tru.setOnClickListener(c ->
        {
            soA.set(Float.valueOf(txt_soA.getText().toString()));
            soB.set(Float.valueOf(txt_soB.getText().toString()));
            result.set(soA.get() - soB.get());
            txt_result.setText(result.toString());
        });
        btn_nhan.setOnClickListener(c ->
        {
            soA.set(Float.valueOf(txt_soA.getText().toString()));
            soB.set(Float.valueOf(txt_soB.getText().toString()));
            result.set(soA.get() * soB.get());
            txt_result.setText(result.toString());
        });

        btn_chia.setOnClickListener(c ->
        {

            soA.set(Float.valueOf(txt_soA.getText().toString()));
            soB.set(Float.valueOf(txt_soB.getText().toString()));
            if (soB.get() == 0) {
                txt_result.setText("Lỗi chia cho 0");
            } else {
                result.set(soA.get() / soB.get());
                txt_result.setText(result.toString());
            }
        });

        img_send.setOnClickListener(c->{
            Intent intent = new Intent(this,ResultActivity.class);
            intent.putExtra(RESULT,result.toString());
            startActivity(intent);
        });

        //exit
        img_exit.setOnClickListener(c-> finish());
    }

}
