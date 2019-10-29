/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprojectDao;

import com.EntityModel.Admin;
import com.EntityModel.Customer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author PC
 */
public class adddDao {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    public boolean login(String adminName,String password){
        boolean result = false;
        Session sess = factory.openSession();
        Query qry = sess.createQuery("From Admin a where a.adminName =:id And a.password =:pass ");
        qry.setParameter("id", adminName);
        qry.setParameter("pass", password);
        List<Admin>list =qry.list();
        
        for(Admin a: list){
            return true;
        }
        sess.close();
    return result;
    
}
    public void signUp(Admin a){
        
        Session sess = factory.openSession();
        Transaction tran = sess.beginTransaction();
        sess.save(a);
        tran.commit();
        sess.close();
        
        
    }
     public boolean ulogin(String userName,String password){
        boolean result = false;
        Session sess = factory.openSession();
        Query qry = sess.createQuery("From Customer a where a.userName =:id And a.password =:pass ");
        qry.setParameter("id", userName);
        qry.setParameter("pass", password);
        List<Customer>list =qry.list();
        
        for(Customer a: list){
            return true;
        }
        sess.close();
    return result;
    
}
    public void usignUp(Customer a){
        
        Session sess = factory.openSession();
        Transaction tran = sess.beginTransaction();
        sess.save(a);
        tran.commit();
        sess.close();
        
        
    }
}
