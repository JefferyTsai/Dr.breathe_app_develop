package com.example.v3_571g.dr_breatheapp;

/**
 * Created by user on 2015/8/27.
 */
public class Account {
    private String id;
    private String password;
    private String name;
    private String sex;
    private long birthday;
    private double height;
    private double weight;
    private String email;

    public Account() {
        name = "";
        sex = "";
    }

    public Account(String _id, String _password, String _name, String _sex, long _birthday, double _height, double _weight, String _email) {
        this.id = _id;
        this.password = _password;
        this.name = _name;
        this.sex = _sex;
        this.birthday = _birthday;
        this.height = _height;
        this.weight = _weight;
        this.email = _email;
    }

    public boolean login(String _id, String _password){
        if(_id.equals(id) && _password.equals(password))return true;
        else return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public  String getPassword(){
        return password;
    }

    public void setPassword(String _password){
        this.password = _password;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String _sex) {
        this.sex = _sex;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long _birthday) {
        this.birthday = _birthday;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double _height) {
        this.height = _height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double _weight) {
        this.weight = _weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }
}
