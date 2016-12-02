package com.example.a403.myapplication1234;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;


import java.util.Calendar;
public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    Chronometer chronometer;
    RadioGroup rs;
    RadioButton radio1,radio2;
    FrameLayout frame;
    TimePicker time;
    CalendarView date;
    TextView text;
    String year,month,day,hour,min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    b1=(Button)findViewById(R.id.button);
        chronometer=(Chronometer)findViewById(R.id.chronometer2);
        rs=(RadioGroup)findViewById(R.id.RadioGroup);
        radio1=(RadioButton)findViewById(R.id.radioButton);
        radio2=(RadioButton)findViewById(R.id.radioButton2);
        frame=(FrameLayout)findViewById(R.id.framelayout);
        time=(TimePicker)findViewById(R.id.timePicker);
        date=(CalendarView)findViewById(R.id.calendarView);
        b2=(Button)findViewById(R.id.button5);
        time.setVisibility(View.INVISIBLE);
       date.setVisibility(View.INVISIBLE);
text=(TextView)findViewById(R.id.textView2);

        radio1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               time.setVisibility(View.INVISIBLE);
                date.setVisibility(View.VISIBLE);
            }
        });

        radio2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                time.setVisibility(View.VISIBLE);
               date.setVisibility(View.INVISIBLE);
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }


        });
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                java.util.Calendar curDate = java.util.Calendar.getInstance();
                curDate.setTimeInMillis(date.getDate());

                year = Integer.toString(curDate.get(Calendar.YEAR));
                month = Integer.toString(1 + curDate.get(Calendar.MONTH));
                day = Integer.toString(curDate.get(Calendar.DATE));

                hour = Integer.toString(time.getCurrentHour());
                min = Integer.toString(time.getCurrentMinute());

                text.setText(year+"/"+month+"/"+day+"/"+hour+"/"+min+"/");
            }
        });
    }
}
