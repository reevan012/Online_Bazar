package com.EntityModel;
// Generated Sep 24, 2019 3:51:19 AM by Hibernate Tools 4.3.1



/**
 * OrderDetails generated by hbm2java
 */
public class OrderDetails  implements java.io.Serializable {


     private Integer orderDetailId;
     private ProOrder proOrder;
     private Product product;
     private int proQty;

    public OrderDetails() {
    }

    public OrderDetails(ProOrder proOrder, Product product, int proQty) {
       this.proOrder = proOrder;
       this.product = product;
       this.proQty = proQty;
    }
   
    public Integer getOrderDetailId() {
        return this.orderDetailId;
    }
    
    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    public ProOrder getProOrder() {
        return this.proOrder;
    }
    
    public void setProOrder(ProOrder proOrder) {
        this.proOrder = proOrder;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getProQty() {
        return this.proQty;
    }
    
    public void setProQty(int proQty) {
        this.proQty = proQty;
    }




}

