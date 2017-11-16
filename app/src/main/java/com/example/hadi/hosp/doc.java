package com.example.hadi.hosp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class doc extends AppCompatActivity implements View.OnClickListener {

    Button days,times;
    TextView thedays, thetimes;

    String a="";
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        Button subm = (Button)findViewById(R.id.SUBMIT);

        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bsda = new Intent(getApplication(), appolist.class);
                startActivity(bsda);
            }
        });

        TextView illtext = (TextView)findViewById(R.id.textView4);
        Intent maint = getIntent();

         a = maint.getStringExtra("name");
        Log.v("something= ", a);

        if (a.equals("1")){
            illtext.setText("Genral Medicine");
        } else if (a.equals("2")){
            illtext.setText("ENT");
        } else if (a.equals("3")){
            illtext.setText("DENTIST");
        }


        days = (Button)findViewById(R.id.day);
        times = (Button)findViewById(R.id.time);

        thedays = (TextView)findViewById(R.id.theday);
        thetimes = (TextView)findViewById(R.id.thetime);

        days.setOnClickListener(this);
        times.setOnClickListener(this);


    }

    public void onClick(View v){

        if (v == days){

            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            thedays.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if (v == times) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            thetimes.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }

    }
    }

