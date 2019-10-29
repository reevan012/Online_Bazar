/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.display;

import com.EntityModel.Product;
import com.aprojectDao.ListDDao;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author PC
 */
@ManagedBean(name = "dispro")
@SessionScoped
public class DisplayProduct {

    Product product = new Product();
    private Product selectedProduct;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Product> getAllProducts() {

        List<Product> plist = new ListDDao().producList();
        return plist;
    }

}
