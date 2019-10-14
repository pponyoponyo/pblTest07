package com.example.pbltest07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private String inputUrl;
    private FirebaseDatabase mFirebaseDB = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.edtInput);

        DatabaseReference dbRef = mFirebaseDB.getReference();

        //공유 기능으로 url data 받기
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        /*
        UrlBean temp = new UrlBean();
        temp.percent = 98;
        temp.reason = "test reason 4";

        dbRef.child("url").child("4444").setValue(temp,1);
*/

    if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);    // 가져온 인텐트의 텍스트 정보
                inputUrl = sharedText;

                sendUrl();
            }
        }

        findViewById(R.id.btnCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputUrl = input.getText().toString();
                input.setText("");

                sendUrl();
            }
        });
    }

    public void sendUrl(){
        Intent i = new Intent(getBaseContext(),ProcessActivity.class);
        i.putExtra("url",inputUrl);
        startActivity(i);
    }
}
