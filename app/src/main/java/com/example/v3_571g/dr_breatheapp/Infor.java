package com.example.v3_571g.dr_breatheapp;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.LocalActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TabHost;

import java.util.Calendar;


public class Infor extends ActionBarActivity {

    private ImageButton myHeadPhotoImageButton;
    private EditText myNameEditText;
    private EditText myWeightEditText;
    private EditText myHeightEditText;
    private EditText myBirthdayEditText;
    private EditText myEmailEditText;
    private int birthdayYear, birthdayMonth, birthdayDay;

    private Button myInfoButton, myHistoryButton, myCourseButton, mySettingButton;
    /*private TabHost myTabHost;
    LocalActivityManager lam;*/
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

        myInfoButton = (Button)findViewById(R.id.infoButton);
        myHistoryButton = (Button)findViewById(R.id.historyButton);
        myCourseButton = (Button)findViewById(R.id.courseButton);
        mySettingButton = (Button)findViewById(R.id.settingButton);
//originally like to using tabHost implement, fail
        /*myTabHost = (TabHost)findViewById(R.id.tabHost);
        lam = new LocalActivityManager(this, false);
        myTabHost.setup(lam);
        lam.dispatchCreate(savedInstanceState);
        Intent intent;

        intent = new Intent().setClass(this, Infor.class);
        TabHost.TabSpec tabSpec1 = myTabHost.newTabSpec("tab1");
        tabSpec1.setIndicator("Infor", ContextCompat.getDrawable(this, R.drawable.ic_drawer));
        tabSpec1.setContent(intent);
        myTabHost.addTab(tabSpec1);

        intent = new Intent().setClass(this, History.class);
        TabHost.TabSpec tabSpec2 = myTabHost.newTabSpec("tab2");
        tabSpec2.setIndicator("History", ContextCompat.getDrawable(this, R.drawable.ic_launcher));
        tabSpec2.setContent(intent);
        myTabHost.addTab(tabSpec2);

        intent = new Intent().setClass(this, Course_Table.class);
        TabHost.TabSpec tabSpec3 = myTabHost.newTabSpec("tab3");
        tabSpec3.setIndicator("Course", ContextCompat.getDrawable(this, R.drawable.ic_launcher));
        tabSpec3.setContent(intent);
        myTabHost.addTab(tabSpec3);

        intent = new Intent().setClass(this, Setting.class);
        TabHost.TabSpec tabSpec4 = myTabHost.newTabSpec("tab4");
        tabSpec4.setIndicator("Setting", ContextCompat.getDrawable(this, R.drawable.ic_launcher));
        tabSpec4.setContent(intent);
        myTabHost.addTab(tabSpec4);*/
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

    @Override
    protected void onPause() {
        super.onPause();
        //lam.dispatchPause(isFinishing());
    }

    @Override
    protected void onResume() {
        super.onResume();
        //lam.dispatchResume();
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
                                +String.valueOf(month+1)+"/"
                                +String.valueOf(dayOfMonth));

                    }
                }, birthdayYear, birthdayMonth, birthdayDay);
        dpd.show();
    }
}
