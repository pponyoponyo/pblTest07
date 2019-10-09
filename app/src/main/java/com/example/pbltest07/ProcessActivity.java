package com.example.pbltest07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ProcessActivity extends AppCompatActivity {

    private String inputUrl;
    private TextView txtTest;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);

        //점검용 textView
        txtTest = findViewById(R.id.txtProcess);

        Intent i = getIntent();
        inputUrl = i.getExtras().getString("url");


        findViewById(R.id.btnProcess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),ResultActivity.class);
                //intent.putExtra();
                startActivity(intent);
                finish();
            }
        });

    }

}
