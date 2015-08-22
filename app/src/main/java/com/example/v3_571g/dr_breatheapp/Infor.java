package com.example.v3_571g.dr_breatheapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;


public class Infor extends ActionBarActivity {

    private ImageButton myHeadPhotoImageButton;
    private Button myNameButton;
    private Button myWeightAndHeightButton;
    private Button myBirthdayButton;
    private Button myGenderButton;
    private Button myEmailButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        myNameButton = (Button)findViewById(R.id.nameButton);
        myWeightAndHeightButton = (Button)findViewById(R.id.bwAndBhButton);
        myBirthdayButton = (Button)findViewById(R.id.birthdayButton);
        myGenderButton = (Button)findViewById(R.id.genderButton);
        myEmailButton = (Button)findViewById(R.id.emailButton);
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
}
