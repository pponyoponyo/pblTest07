package com.example.pbltest07;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class PopupActivity extends Activity {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        final CheckBox cbRepeat = findViewById(R.id.cbRepeat);
        sp  = getSharedPreferences("PBL",MODE_PRIVATE);

        findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();

                if(cbRepeat.isChecked()){
                    editor.putBoolean("popup", false);
                }

                editor.commit();
                finish();
            }
        });
    }
}
