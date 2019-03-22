package com.vijay.beforecalendardatevalidation;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText start_date;
    private String temp = "", tempday = "", dateselected = "";
    int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_date = findViewById(R.id.start_date);


        start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                open_date();

            }
        });
    }

    private void open_date() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                if (String.valueOf((monthOfYear + 1)).length() == 1) {
                    temp = "0" + String.valueOf((monthOfYear + 1));
                } else {
                    temp = String.valueOf((monthOfYear + 1));
                }

                if (String.valueOf((dayOfMonth)).length() == 1) {
                    tempday = "0" + String.valueOf(dayOfMonth);
                } else {
                    tempday = String.valueOf(dayOfMonth);
                }

                start_date.setText(dayOfMonth + "/" + temp + "/" + year);
                dateselected = dayOfMonth + "/" + temp + "/" + year;
            }

        }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }
}
