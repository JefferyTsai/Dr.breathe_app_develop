package com.example.v3_571g.dr_breatheapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private EditText inputEditText1;
    private EditText inputEditText2;
    private Button sendButton1;
    private Button sendButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);
        inputEditText1 = (EditText) findViewById(R.id.editText1);
        inputEditText2 = (EditText) findViewById(R.id.editText2);
        sendButton1 = (Button) findViewById(R.id.Accept);
        sendButton2 = (Button) findViewById(R.id.Cancel);
    }
    public void goToMain(View view){
        Intent intent = new Intent(this,Main.class);
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
