package com.example.pbltest07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Process2Activity extends AppCompatActivity {

    private TextView txtTest;
    private String inputUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process2);
        txtTest = findViewById(R.id.txtProcess);

        Intent i = getIntent();
        inputUrl = i.getExtras().getString("url");

        RuleChain ruleChain = new RuleChain(this);
        ruleChain.totalCheck(inputUrl);

        RuleBase ruleBase = new RuleBase(this);

        finish();
    }
}
