/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprojectDao;


import com.EntityModel.Category;
import com.EntityModel.Product;
import com.EntityModel.SubCategory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author PC
 */
public class AddDao {
    
    public boolean addCat(Category cat){
        try{
                SessionFactory factory = HibernateUtil.getSessionFactory();
        Session sess = factory.openSession();
            Transaction tran = sess.beginTransaction();
                    sess.save(cat);
                    tran.commit();
                    sess.close();
                    return true;
        }catch(Exception e){
                    return false;
        }
    }
    public boolean addSubCat(SubCategory subcat){
        try{
                SessionFactory factory = HibernateUtil.getSessionFactory();
        Session sess = factory.openSession();
            Transaction tran = sess.beginTransaction();
                    sess.save(subcat);
                    tran.commit();
                    sess.close();
                    return true;
        }catch(Exception e){
                    return false;
        }
    }
     public boolean addProduct(Product product){
        try{
                SessionFactory factory = HibernateUtil.getSessionFactory();
        Session sess = factory.openSession();
            Transaction tran = sess.beginTransaction();
                    sess.save(product);
                    tran.commit();
                    sess.close();
                    return true;
        }catch(Exception e){
                    return false;
        }

    }
}
     