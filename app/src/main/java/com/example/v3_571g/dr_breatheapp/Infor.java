package com.example.v3_571g.dr_breatheapp;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;


public class Infor extends ActionBarActivity {

    private ImageButton myHeadPhotoImageButton;
    private EditText myNameEditText;
    private EditText myWeightEditText;
    private EditText myHeightEditText;
    private EditText myBirthdayEditText;
    private EditText myEmailEditText;
    private int birthdayYear, birthdayMonth, birthdayDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);

        myHeadPhotoImageButton = (ImageButton) findViewById(R.id.headPhotoButton);
        myNameEditText = (EditText) findViewById(R.id.nameEditText);
        myWeightEditText = (EditText) findViewById(R.id.weightEditText);
        myHeightEditText = (EditText) findViewById(R.id.heightEditText);
        myBirthdayEditText = (EditText) findViewById(R.id.birthdayEditText);
        myEmailEditText = (EditText) findViewById(R.id.emailEditText);

        myBirthdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_infor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showDatePickerDialog(){
        final Calendar c = Calendar.getInstance();
        birthdayYear = c.get(Calendar.YEAR);
        birthdayMonth = c.get(Calendar.MONTH);
        birthdayDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener(){
                    public void onDateSet(DatePicker View, int year, int month, int dayOfMonth){
                        myBirthdayEditText.setText(String.valueOf(year)+"/"
                                +String.valueOf(month)+"/"
                                +String.valueOf(dayOfMonth));

                    }
                }, birthdayYear, birthdayMonth, birthdayDay);
        dpd.show();
    }
}
