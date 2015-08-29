package com.example.v3_571g.dr_breatheapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Register extends AppCompatActivity {
    private AccountDAO accountDAO;
    private EditText accountId;
    private EditText password;
    private EditText name;
    private RadioButton male;
    private RadioButton female;
    private EditText birthday;
    private EditText height;
    private EditText weight;
    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 建立資料庫物件
        accountDAO = new AccountDAO(getApplicationContext());

        accountId = (EditText)findViewById(R.id.accountId);
        password = (EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        male = (RadioButton)findViewById(R.id.male);
        female = (RadioButton)findViewById(R.id.female);
        birthday = (EditText)findViewById(R.id.birthday);
        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        email = (EditText)findViewById(R.id.email);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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

    public void addNewAccount(View view) throws ParseException {
        String sex="";
        if(male.isSelected())sex="male";
        else if(female.isSelected())sex="female";
        //SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY");
        //Date myDate = df.parse(birthday.getText().toString());
        Account account=new Account(accountId.getText().toString(),password.getText().toString(),name.getText().toString(),sex, Integer.parseInt(birthday.getText().toString()),Double.parseDouble(height.getText().toString()),Double.parseDouble(weight.getText().toString()),email.getText().toString());

        AlertDialog.Builder MyAlertDialog = new AlertDialog.Builder(this);

        if(accountDAO.insert(account)==-1){
            MyAlertDialog.setTitle("失敗");
            MyAlertDialog.setMessage("未填完資訊或其他錯誤 ");
            MyAlertDialog.show();
        }
        else{
            MyAlertDialog.setTitle("成功");
            MyAlertDialog.setMessage("創建成功 ");
            MyAlertDialog.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}
