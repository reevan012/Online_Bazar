/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprojectController;

import com.EntityModel.Product;
import com.EntityModel.SubCategory;
import com.aprojectDao.AddDao;
import com.aprojectDao.ListDDao;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;

import org.primefaces.model.UploadedFile;

/**
 *
 * @author PC
 */
@ManagedBean(name = "addpro")
@SessionScoped
public class ProductController implements Serializable {

    Product pro = new Product();
    SubCategory subcat = new SubCategory();
    String subcatname;
    String catname = "";
    List<SubCategory> sublistCat;
    UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public Product getPro() {
        return pro;
    }

    public void setPro(Product pro) {
        this.pro = pro;
    }

    public SubCategory getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCategory subcat) {
        this.subcat = subcat;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public List<SubCategory> getSublistCat() {
        return sublistCat;
    }

    public void setSublistCat(List<SubCategory> sublistCat) {
        this.sublistCat = sublistCat;
    }

    public String addProduct() {
        upload();
        sublistCat = new ListDDao().subCatListByName(subcatname);
        subcat.setSubId(sublistCat.get(0).getSubId());
        pro.setSubCategory(subcat);
        pro.setProName(pro.getProName());
        pro.setProQuantity(pro.getProQuantity());
        pro.setProPrice(pro.getProPrice());
        pro.setProUrl(pro.getProUrl());
        pro.setProDsc(pro.getProDsc());
        boolean status = new AddDao().addProduct(pro);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "data save", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "data not save", ""));
        }
        return "display";
    }

    public void upload() {

        if (file != null) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
                String dbpath = servletContext.getRealPath("/");
                String webcut = dbpath.substring(0, dbpath.lastIndexOf("\\"));
                String buildcut = webcut.substring(0, webcut.lastIndexOf("\\"));
                String mainURLPath = buildcut.substring(0, buildcut.lastIndexOf("\\"));
                InputStream inputstream = file.getInputstream();
                String path = mainURLPath + "\\web\\resources\\images\\" + file.getFileName();
                File desFile = new File(path);
                if (!desFile.exists()) {
                    FileUtils.copyInputStreamToFile(inputstream, desFile);
                    
                    }
           
                    pro.setProUrl(file.getFileName().toString());
                

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public List<SelectItem> getSubCategoryName() {
        List<SelectItem> subcatname = new ListDDao().subCatList(catname);

        return subcatname;
    }
}
