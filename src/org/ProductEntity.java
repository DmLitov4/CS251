package org;

import javax.persistence.*;

/**
 * Created by rasiel on 26.04.16.
 */
@Entity
@Table(name = "PRODUCT", schema = "", catalog = "")
public class ProductEntity {
    private int idProduct;
    private String nomenclature;
    private String unit;

    @Id
    @Column(name = "ID_PRODUCT")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "NOMENCLATURE")
    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    @Basic
    @Column(name = "UNIT")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (idProduct != that.idProduct) return false;
        if (nomenclature != null ? !nomenclature.equals(that.nomenclature) : that.nomenclature != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduct;
        result = 31 * result + (nomenclature != null ? nomenclature.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
