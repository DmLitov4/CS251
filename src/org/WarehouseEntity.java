package org;

import javax.persistence.*;

/**
 * Created by rasiel on 16.04.16.
 */
@Entity
@Table(name = "WAREHOUSE", schema = "", catalog = "")
public class WarehouseEntity {
    private int idWarehouse;
    private String name;
    private String town;

    @Id
    @Column(name = "ID_WAREHOUSE")
    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "TOWN")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WarehouseEntity that = (WarehouseEntity) o;

        if (idWarehouse != that.idWarehouse) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (town != null ? !town.equals(that.town) : that.town != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWarehouse;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        return result;
    }
}
