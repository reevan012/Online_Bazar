/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprojectDao;


import com.EntityModel.Category;
import com.EntityModel.Product;
import com.EntityModel.SubCategory;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author PC
 */
public class ListDDao {
    SessionFactory factory = HibernateUtil.getSessionFactory();
   
     public List catList(){
        Session sess = factory.openSession();
        List<Category> catList = sess.createQuery(" select a.catName From Category a").list();
        catList.toString();
        sess.close();
        return catList;
    } 
      public List subCatList(String name){
        Session sess = factory.openSession();
        List<Category> catList = sess.createQuery("Select a.subCatName From SubCategory a where a.category.catId IN(select c.catId From Category c where lower(c.catName)='"+name.toLowerCase()+"')").list();
        catList.toString();
        sess.close();
        return catList;
    } 
       public List producList(){
        Session sess = factory.openSession();
        List<Product> catList = sess.createQuery("From Product p").list();
         catList.toString();
        sess.close();
        return catList;
    }
  
      public List<Category> catListByName(String name){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        System.out.println("name ----------- "+name);
        Session sess = factory.openSession();
        List<Category> catList = sess.createQuery("Select a From Category a where lower(catName)='"+name.toLowerCase()+"'").list();
        catList.toString();
               sess.close();
        return catList;
           
               
         
    }
     public List<SubCategory> subCatListByName(String name){
        Session sess = factory.openSession();
            List<SubCategory> subcatList = sess.createQuery("Select a From SubCategory a where lower(subCatName)='"+name.toLowerCase()+"'").list();
               subcatList.toString();
               sess.close();
        return subcatList;
    }
    public List getAllProduct(String name){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session sess = factory.openSession();
        List<Category> catList = sess.createQuery("Select a.subCatName From SubCategory a where a.category.catId IN(select c.catId From Category c where lower(c.catName)='"+name.toLowerCase()+"')").list();
         catList.toString();
        sess.close();
        return catList;
    }
    
    
        public List allproListByName(String catname){
        Session sess = factory.openSession();
        List<Product> catList = sess.createQuery("Select product From SubCategory s, Category c, Product p where s.c.catId = c.catId AND p.s.subcatId = s.subcatId AND (c.catName ='"+catname+"')").list();
         catList.toString();
        sess.close();
        return catList;

      }
      
//       public boolean login(String user_name, String password){
//        boolean result = false;
//        Session sess = factory.openSession();
//        Query query = sess.createQuery("From ShopeUse su where su.user_name=:id AND su.password=:pass");
//        query.setParameter("id", user_name);
//        query.setParameter("pass", password);
//        List<ShopeUse> user = query.list();
//        for(ShopeUse su: user){
//        result =true;
//        }
//        sess.close();
//        return result;
//    }
}
