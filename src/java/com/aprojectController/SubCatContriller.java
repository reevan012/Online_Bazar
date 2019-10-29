/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprojectController;



import com.EntityModel.Category;
import com.EntityModel.SubCategory;
import com.aprojectDao.AddDao;
import com.aprojectDao.ListDDao;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author PC
 */
@ManagedBean(name="subAdd")
@SessionScoped
public class SubCatContriller implements Serializable{
    SubCategory subcat = new  SubCategory();
    String catname;
     Category category = new Category();
    List<Category> lisstCat;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    public SubCategory getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCategory subcat) {
        this.subcat = subcat;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public List<Category> getLisstCat() {
        return lisstCat;
    }

    public void setLisstCat(List<Category> lisstCat) {
        this.lisstCat = lisstCat;
    }
    
    public String addSubCategory(){
        System.out.println("CatName --------- "+catname);
            lisstCat = new ListDDao().catListByName(catname);
            System.out.println(lisstCat.get(0).getCatId());
            // subcat.setSubId(lisstCat.get(0).getCatId());
            category.setCatId(lisstCat.get(0).getCatId());
            subcat.setCategory(category);
           
            subcat.setSubCatName(subcat.getSubCatName());
            subcat.setSubCatDsc(subcat.getSubCatDsc());
           boolean status = new AddDao().addSubCat(subcat);
           if(status){
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "data save", ""));
           }else{
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "data not save", ""));
           }
            return "addproduct";
        }
        public List<SelectItem> getCategoryName(){
         List<SelectItem> catname = new ListDDao().catList();
        
        return catname ;
        }    
}
