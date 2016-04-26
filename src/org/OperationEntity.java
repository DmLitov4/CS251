package org;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by rasiel on 26.04.16.
 */
@Entity
@Table(name = "OPERATION", schema = "", catalog = "")
public class OperationEntity {
    private int idOperation;
    private int idProduct;
    private int idAgent;
    private int idWarehouse;
    private int idSeller;
    private String optype;
    private BigDecimal amount;
    private BigDecimal price;
    private Date postDate;
    private double discount;

    @Id
    @Column(name = "ID_OPERATION")
    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    @Basic
    @Column(name = "ID_PRODUCT")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "ID_AGENT")
    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    @Basic
    @Column(name = "ID_WAREHOUSE")
    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    @Basic
    @Column(name = "ID_SELLER")
    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    @Basic
    @Column(name = "OPTYPE")
    public String getOptype() {
        return optype;
    }

    public void setOptype(String optype) {
        this.optype = optype;
    }

    @Basic
    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "POST_DATE")
    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Basic
    @Column(name = "DISCOUNT")
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationEntity that = (OperationEntity) o;

        if (idOperation != that.idOperation) return false;
        if (idProduct != that.idProduct) return false;
        if (idAgent != that.idAgent) return false;
        if (idWarehouse != that.idWarehouse) return false;
        if (idSeller != that.idSeller) return false;
        if (Double.compare(that.discount, discount) != 0) return false;
        if (optype != null ? !optype.equals(that.optype) : that.optype != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (postDate != null ? !postDate.equals(that.postDate) : that.postDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idOperation;
        result = 31 * result + idProduct;
        result = 31 * result + idAgent;
        result = 31 * result + idWarehouse;
        result = 31 * result + idSeller;
        result = 31 * result + (optype != null ? optype.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (postDate != null ? postDate.hashCode() : 0);
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
