package com.tecmis.dto;

import java.text.SimpleDateFormat;


public class LecturerData  extends  User{

    public LecturerData(){

        this.userAccountType="lecturer";
    }
    private String Id;
    private  String firstName;
    private String username;
    private  String password;
    private String lastName;
    private String  mobile;
    private String  address;
    private String age;
    private String email;

    private String dom;

    private String gender;

    private String position;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getId(){
        return Id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMobile(){
        return mobile;
    }
    public String getAddress(){
        return address;
    }
    public String getAge(){
        return age;
    }
    public  String getEmail(){
        return email;
    }
    public String getDom(){
        return dom;
    }
    public String getGender(){
        return gender;
    }
    public String getPosition(){
        return position;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setId(String Id){
        this.Id=Id;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setMobile(String mobile){
        this.mobile=mobile;
    }

    public void setAddress(String address){
        this.address=address;
    }
    public  void setAge(String age){
        this.age=age;
    }

    public  void setEmail(String email){
        this.email=email;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }
    public  void setGender(String gender){

        this.gender=gender == "Male" ? "M" : "F";
    }
    public void setPosition(String position){

        this.position=position;
    }


    public void getFromHash(){

    }


}
