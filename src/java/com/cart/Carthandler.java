/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cart;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author PC
 */
        @ManagedBean(name = "carthandl")
        @SessionScoped
public class Carthandler {
     int productid;       
    List<CartBind> cartdList = new ArrayList<CartBind>();
     String productname;
    int quantity;
    double price;
    double total;
     Map<Integer, CartBind> map = new HashMap<Integer,CartBind>();
     int cartSize;
     String item;

    public String getItem() {
        return item = "item";
    }

    public void setItem(String item) {
        this.item = item;
    }
     
     
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

     
    public int getCartSize() {
        return cartSize;
    }

    public void setCartSize(int cartSize) {
        this.cartSize = cartSize;
    }
     
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
    
    
     
     public List<CartBind> getCartdList() {
        return cartdList;
    }

    public void setCartdList(List<CartBind> cartdList) {
        this.cartdList = cartdList;
    }

   

    public Map<Integer, CartBind> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartBind> map) {
        this.map = map;
    }
   public String processCart(int qty){
       
         CartBind cartd = new CartBind();
         quantity = qty;
       cartd.setProductname(productname);
       cartd.setQuantity(quantity);
       cartd.setPrice(price);
       cartd.setTotal(quantity*price);
       cartdList.add(cartd);
       map.put(productid, cartd);
       cartSize = cartdList.size();
       if(cartSize>1){
       item = "items";
       }
   return null;
   }
            
    
}
