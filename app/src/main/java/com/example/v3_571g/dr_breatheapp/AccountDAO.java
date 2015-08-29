package com.example.v3_571g.dr_breatheapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

// 資料功能類別
public class AccountDAO {
    // 表格名稱
    public static final String TABLE_NAME = "account";

    // 編號表格欄位名稱，固定不變
    public static final String KEY_ID = "_id";

    // 其它表格欄位名稱
    public static final String NAME_COLUMN = "name";
    public static final String PASSWORD_COLUMN = "password";
    public static final String SEX_COLUMN = "sex";
    public static final String BIRTHDAY_COLUMN = "birthday";
    public static final String HEIGHT_COLUMN = "height";
    public static final String WEIGHT_COLUMN = "weight";
    public static final String EMAIL_COLUMN = "email";

    // 使用上面宣告的變數建立表格的SQL指令
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " TEXT PRIMARY KEY, " +
                    PASSWORD_COLUMN + " TEXT NOT NULL, " +
                    NAME_COLUMN + " TEXT NOT NULL, " +
                    SEX_COLUMN + " TEXT NOT NULL, " +
                    BIRTHDAY_COLUMN + " INTEGER NOT NULL, " +
                    HEIGHT_COLUMN + " REAL NOT NULL, " +
                    WEIGHT_COLUMN + " REAL  NOT NULL, " +
                    EMAIL_COLUMN + " TEXT NOT NULL) " ;

    // 資料庫物件
    private SQLiteDatabase db;

    // 建構子，一般的應用都不需要修改
    public AccountDAO(Context context) {
        db = MyDBHelper.getDatabase(context);
    }

    // 關閉資料庫，一般的應用都不需要修改
    public void close() {
        db.close();
    }

    // 新增參數指定的物件
    public long insert(Account account) {
        // 建立準備新增資料的ContentValues物件
        ContentValues cv = new ContentValues();

        // 加入ContentValues物件包裝的新增資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料
        cv.put(KEY_ID, account.getId());
        cv.put(PASSWORD_COLUMN, account.getPassword());
        cv.put(NAME_COLUMN, account.getName());
        cv.put(SEX_COLUMN, account.getSex());
        cv.put(BIRTHDAY_COLUMN, account.getBirthday());
        cv.put(HEIGHT_COLUMN, account.getHeight());
        cv.put(WEIGHT_COLUMN, account.getWeight());
        cv.put(EMAIL_COLUMN, account.getEmail());


        // 新增一筆資料並取得編號
        // 第一個參數是表格名稱
        // 第二個參數是沒有指定欄位值的預設值
        // 第三個參數是包裝新增資料的ContentValues物件
        // db  = SQLiteDatabase.openDatabase(anruledb.getPath(), null,	SQLiteDatabase.OPEN_READWRITE);
        return db.insert(TABLE_NAME, null, cv);




    }

    // 修改參數指定的物件
    public boolean update(Account account) {
        // 建立準備修改資料的ContentValues物件
        ContentValues cv = new ContentValues();

        // 加入ContentValues物件包裝的修改資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料
        cv.put(PASSWORD_COLUMN, account.getPassword());
        cv.put(NAME_COLUMN, account.getName());
        cv.put(SEX_COLUMN, account.getSex());
        cv.put(BIRTHDAY_COLUMN, account.getBirthday());
        cv.put(HEIGHT_COLUMN, account.getHeight());
        cv.put(WEIGHT_COLUMN, account.getWeight());
        cv.put(EMAIL_COLUMN, account.getEmail());

        // 設定修改資料的條件為編號
        // 格式為「欄位名稱＝資料」
        String where = KEY_ID + "=" + account.getId();

        // 執行修改資料並回傳修改的資料數量是否成功
        return db.update(TABLE_NAME, cv, where, null) > 0;
    }

    // 刪除參數指定編號的資料
    public boolean delete(long id){
        // 設定條件為編號，格式為「欄位名稱=資料」
        String where = KEY_ID + "=" + id;
        // 刪除指定編號資料並回傳刪除是否成功
        return db.delete(TABLE_NAME, where , null) > 0;
    }

    // 讀取所有記事資料
    public List<Account> getAll() {
        List<Account> result = new ArrayList<>();
        Cursor cursor = db.query(
                TABLE_NAME, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }

        cursor.close();
        return result;
    }

    // 取得指定編號的資料物件
    public Account get(String id) {
        // 準備回傳結果用的物件
        Account account = null;
        // 使用編號為查詢條件
        String where = KEY_ID + "=\"" + id +"\"";
        // 執行查詢
        Cursor result = db.query(
                TABLE_NAME, null, where, null, null, null, null, null);

        // 如果有查詢結果
        if (result.moveToFirst()) {
            // 讀取包裝一筆資料的物件
            account = getRecord(result);
        }

        // 關閉Cursor物件
        result.close();
        // 回傳結果
        return account;
    }

    // 把Cursor目前的資料包裝為物件
    public Account getRecord(Cursor cursor) {
        // 準備回傳結果用的物件
        Account result = new Account();

        result.setId(cursor.getString(0));
        result.setPassword(cursor.getString(1));
        result.setName(cursor.getString(2));
        result.setSex(cursor.getString(3));
        result.setBirthday(cursor.getLong(4));
        result.setHeight(cursor.getDouble(5));
        result.setWeight(cursor.getDouble(6));
        result.setEmail(cursor.getString(7));

        // 回傳結果
        return result;
    }

    // 取得資料數量
    public int getCount() {
        int result = 0;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);

        if (cursor.moveToNext()) {
            result = cursor.getInt(0);
        }

        return result;
    }

    //登入
    public Account login(String _id, String _password){
        Account account = get(_id);
        if(account==null)return  null;
        else if(account.getPassword().equals(_password))return account;
        else return null;

    }

    // 建立範例資料
    public void sample() {
        Account sample = new Account("test","test","test","male",82129,180,70,"hsjfhsdf@gmail.com");
        insert(sample);
        //db.execSQL("insert into "+TABLE_NAME+"("+KEY_ID+","+NAME_COLUMN+","+PASSWORD_COLUMN+","+SEX_COLUMN+","+BIRTHDAY_COLUMN+","+HEIGHT_COLUMN+","+WEIGHT_COLUMN+","+EMAIL_COLUMN+") values('test','test','test','male',82129,180,70,'hsjfhsdf@gmail.com');");
    }

}