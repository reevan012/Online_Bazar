/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjectHandller;

import com.EntityModel.Admin;
import com.EntityModel.Customer;
import com.aprojectDao.adddDao;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author PC
 */
@ManagedBean(name = "log")
@SessionScoped
public class Admins {

      private int id;
     private String adminName;
     private String emailAddress;
     private String contactNo;
     private String password;
     private Date date;
     private String gender;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
     private String userName;



   

    

    
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    adddDao dao = new adddDao();
    public String login(){
        boolean res = dao.login(adminName, password);
        if(res== false){
            return "admin";
        }
        
        return "categoryAdd";
    } 
    public String signup(){
        dao.signUp(new Admin(adminName, emailAddress, contactNo, password));
        return "Adminlogin";
    }
     public String ulogin(){
        boolean res = dao.ulogin(userName, password);
        if(res== false){
            return "customer";
        }
        
        return "display";
    } 
    public String usignup(){
        dao.usignUp(new Customer(userName, emailAddress, password, date, contactNo, gender));
        return "customerLog";
    }
    
}
