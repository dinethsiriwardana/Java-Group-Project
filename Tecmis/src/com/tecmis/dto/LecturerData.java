package com.tecmis.dto;

import java.util.Date;

public class LecturerData  extends  User{

    public LecturerData(){
        this.userAccountType="lecturer";
    }
    private String Id;
    private  String firstName;
    private String lastName;
    private int mobile;
    private String  address;
    private int age;
    private String email;
    private Date dom;

    private String gender;

    private String position;

    public String getId(){
        return Id;
    }
    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public int getMobile(){
        return mobile;
    }

    public String getAddress(){
        return address;
    }
    public int getAge(){
        return age;
    }
    public  String getEmail(){
        return email;
    }
    public Date getDom(){
        return dom;
    }
    public String getGender(){
        return gender;
    }
    public String getPosition(){
        return position;
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
    public void setMobile(int mobile){
        this.mobile=mobile;
    }

    public void setAddress(String address){
        this.address=address;
    }
    public  void setAge(int age){
        this.age=age;
    }

    public  void setEmail(String email){
        this.email=email;
    }

    public void setDom(Date dom){
        this.dom=dom;
    }
    public  void setGender(String gender){
        this.gender=gender;
    }
    public void setPosition(String position){
        this.position=position;
    }
}
