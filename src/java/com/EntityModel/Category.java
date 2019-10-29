package com.EntityModel;
// Generated Sep 24, 2019 3:51:19 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private Integer catId;
     private String catName;
     private String catDsc;
     private Set subCategories = new HashSet(0);

    public Category() {
    }

	
    public Category(String catName) {
        this.catName = catName;
    }
    public Category(String catName, String catDsc, Set subCategories) {
       this.catName = catName;
       this.catDsc = catDsc;
       this.subCategories = subCategories;
    }
   
    public Integer getCatId() {
        return this.catId;
    }
    
    public void setCatId(Integer catId) {
        this.catId = catId;
    }
    public String getCatName() {
        return this.catName;
    }
    
    public void setCatName(String catName) {
        this.catName = catName;
    }
    public String getCatDsc() {
        return this.catDsc;
    }
    
    public void setCatDsc(String catDsc) {
        this.catDsc = catDsc;
    }
    public Set getSubCategories() {
        return this.subCategories;
    }
    
    public void setSubCategories(Set subCategories) {
        this.subCategories = subCategories;
    }




}


