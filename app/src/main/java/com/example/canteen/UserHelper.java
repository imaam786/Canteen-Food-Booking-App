package com.example.canteen;

public class UserHelper {

    String regno,name,dept,year, email, pass;
    String price,name1,amount1,note1;

    String tid,trid,des,amount,detail;

    public UserHelper(String name, String email, String regno, String pass,String dept, String year) {
        this.name = name;
        this.regno = regno;
        this.email = email;
        this.dept = dept;
        this.year=year;
        this.pass = pass;

    }

    public UserHelper(String name, String price) {

        this.name=name;
        this.price=price;
    }

    public UserHelper(String name1, String amount1, String note1) {
        this.name1=name1;
        this.amount1=amount1;
        this.note1=note1;
    }

    public UserHelper(String tid, String trid, String des, String amount, String detail) {

        this.tid=tid;
        this.trid=trid;
        this.des=des;
        this.amount=amount;
        this.detail=detail;
    }


public String getDetail(){
        return detail;
}
public void setDetail(){
        this.detail=detail;
}
    public String getTid(){
        return tid;
    }
    public void setTid(){
        this.tid=tid;
    }
    public String getTrid(){
        return trid;
    }
    public void setTrid(){
        this.trid=trid;
    }
    public String getDes(){
        return des;
    }
    public void setDes(){
        this.des=des;
    }
    public String getAmount(){
        return amount;
    }
    public void setAmount(){
        this.amount=amount;
    }



    public String getName1(){return name1;}


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
