package com.example.hadi.hosp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class verific extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verific);




        final EditText vedit = (EditText)findViewById(R.id.veriedit);

        Button vsub = (Button)findViewById(R.id.verisub);

        vsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vericode;

                vericode = vedit.getText().toString();

                if (vericode.equals("12345")){
                    Toast.makeText(getApplicationContext(),"Verified!",Toast.LENGTH_LONG).show();

                    Intent suc = new Intent(getApplication(), MainActivity.class);
                    startActivity(suc);
                } else {
                    Toast.makeText(getApplicationContext(),"Verification Unsuccesfull",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
