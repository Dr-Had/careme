package com.example.hadi.hosp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton gmedicine,ear,dent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gmedicine = (ImageButton)findViewById(R.id.genrealmed);
        ear = (ImageButton)findViewById(R.id.ent);
        dent = (ImageButton)findViewById(R.id.dentist);

        gmedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent go1 = new Intent(getApplication(), doc.class);
                go1.putExtra("name", "1");
                startActivity(go1);
            }
        });

        ear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent go2 = new Intent(getApplication(), doc.class);
                go2.putExtra("name", "2");
                startActivity(go2);
            }
        });

        dent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go3 = new Intent(getApplication(), doc.class);
                go3.putExtra("name", "3");
                startActivity(go3);

            }
        });
    }
}
