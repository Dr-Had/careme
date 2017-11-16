package com.example.hadi.hosp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class regpage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regpage);

        final EditText name = (EditText)findViewById(R.id.namebox);
        final EditText phone = (EditText)findViewById(R.id.phonebox);

        Button sumbit = (Button) findViewById(R.id.regsubmit);

        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplication(), verific.class);
                startActivity(go);
            }
        });


    }
}
