package com.example.pbltest07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProcessActivity extends AppCompatActivity {

    private String inputUrl;
    private FirebaseDatabase mFirebaseDB = FirebaseDatabase.getInstance();
    private Boolean done = false;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);

        Intent i = getIntent();
        inputUrl = i.getExtras().getString("url");

        compDB();

    }

    public void compDB(){

        mFirebaseDB.getReference().child("url").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                    UrlBean urlComp = snapshot.getValue(UrlBean.class);
                    String url = snapshot.getKey();

                    if(url.equals(inputUrl)){
                        Bundle data = new Bundle();
                        data.putString("reason",urlComp.reason);
                        data.putInt("percent",urlComp.percent);

                        Intent intent = new Intent(getBaseContext(),ResultActivity.class);
                        intent.putExtras(data);

                        startActivity(intent);
                        done = true;
                    }
                }

                if(done == false){
                    Intent i = new Intent(getBaseContext(),Process2Activity.class);
                    i.putExtra("url",inputUrl);
                    startActivity(i);
                }
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }

}
