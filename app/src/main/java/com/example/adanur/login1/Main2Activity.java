package com.example.adanur.login1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView kk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        kk=(TextView)findViewById(R.id.textView3);

        Intent intent=getIntent();
        String name=intent.getStringExtra("key");
        kk.setText(name);
        Toast.makeText(Main2Activity.this,"you have successfully logged",Toast.LENGTH_LONG).show();


    }
}