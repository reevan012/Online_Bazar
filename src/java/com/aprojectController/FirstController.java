/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprojectController;

import com.EntityModel.Category;
import com.aprojectDao.AddDao;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC
 */
@ManagedBean(name="add")
@SessionScoped

public class FirstController  implements Serializable{
        Category category = new Category();

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
        
        public String addCategory(){
           category.setCatName(category.getCatName());
           category.setCatDsc(category.getCatDsc());
           boolean status = new AddDao().addCat(category);
           if(status){
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "data save", ""));
           }else{
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "data not save", ""));
           }
            return "subCategooryAdd";
        }
    
}
