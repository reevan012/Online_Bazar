package com.EntityModel;
// Generated Sep 24, 2019 3:51:19 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * SubCategory generated by hbm2java
 */
public class SubCategory  implements java.io.Serializable {


     private Integer subId;
     private Category category;
     private String subCatName;
     private String subCatDsc;
     private Set products = new HashSet(0);

    public SubCategory() {
    }

	
    public SubCategory(String subCatName) {
        this.subCatName = subCatName;
    }
    public SubCategory(Category category, String subCatName, String subCatDsc, Set products) {
       this.category = category;
       this.subCatName = subCatName;
       this.subCatDsc = subCatDsc;
       this.products = products;
    }
   
    public Integer getSubId() {
        return this.subId;
    }
    
    public void setSubId(Integer subId) {
        this.subId = subId;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getSubCatName() {
        return this.subCatName;
    }
    
    public void setSubCatName(String subCatName) {
        this.subCatName = subCatName;
    }
    public String getSubCatDsc() {
        return this.subCatDsc;
    }
    
    public void setSubCatDsc(String subCatDsc) {
        this.subCatDsc = subCatDsc;
    }
    public Set getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }




}

