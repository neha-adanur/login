package com.example.adanur.login1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tv1,tv2;
Button b1,b2;
    EditText ed1,ed2;
Databasehelper helper=new Databasehelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView2);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);


    }
    public void login(View view) {
        String n1 = ed1.getText().toString();
        String n2 = ed2.getText().toString();
        String password=helper.srcpass(n1);//search for password in db
        if(password.equals(n2))
        {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("key", n1);
            startActivity(intent);

        }
        else
            Toast.makeText(MainActivity.this,"no matches",Toast.LENGTH_SHORT).show();

    }
    public void signup(View view)
    {
        Intent intent1=new Intent(MainActivity.this,Main3Activity.class);
        startActivity(intent1);
    }
}
