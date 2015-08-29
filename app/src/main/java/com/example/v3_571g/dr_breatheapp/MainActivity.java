package com.example.v3_571g.dr_breatheapp;

import android.app.AlertDialog;
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
    private AccountDAO accountDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);
        inputEditText1 = (EditText) findViewById(R.id.accountId);
        inputEditText2 = (EditText) findViewById(R.id.password);
        sendButton1 = (Button) findViewById(R.id.Accept);
        sendButton2 = (Button) findViewById(R.id.Cancel);

        accountDAO = new AccountDAO(getApplicationContext());

        if(accountDAO.getCount()==0){

            accountDAO.sample();
        }
    }
    public void goToMain(View view){
        if(accountDAO.login(inputEditText1.getText().toString(),inputEditText2.getText().toString())!=null) {
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        }
        else{
            AlertDialog.Builder MyAlertDialog = new AlertDialog.Builder(this);

            MyAlertDialog.setTitle("失敗");

            MyAlertDialog.setMessage("帳密錯誤 "+accountDAO.getCount());

            MyAlertDialog.show();
        }
    }

    public void goToRegister(View view){
        Intent intent = new Intent(this,Register.class);
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
