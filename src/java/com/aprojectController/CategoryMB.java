/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprojectController;

import com.EntityModel.Category;
import com.aprojectDao.ListDDao;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author PC
 */
@ManagedBean(name = "cmb")
@SessionScoped
public class CategoryMB {
    Category category = new Category();
    private List<Category> allcat = new ArrayList<>();

    public Category getCategory() {
        
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getAllcat() {
        allcat = new ListDDao().catList();
        return allcat;
    }

    public void setAllcat(List<Category> allcat) {
        this.allcat = allcat;
    }
    
    
}
