package org;

import javax.persistence.*;

/**
 * Created by rasiel on 13.04.16.
 */
@Entity
@Table(name = "WAREHOUSE", schema = "", catalog = "")
public class WarehouseEntity {
    private String idWh;
    private String naimen;
    private String town;

    @Id
    @Column(name = "ID_WH")
    public String getIdWh() {
        return idWh;
    }

    public void setIdWh(String idWh) {
        this.idWh = idWh;
    }

    @Basic
    @Column(name = "NAIMEN")
    public String getNaimen() {
        return naimen;
    }

    public void setNaimen(String naimen) {
        this.naimen = naimen;
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

        if (idWh != null ? !idWh.equals(that.idWh) : that.idWh != null) return false;
        if (naimen != null ? !naimen.equals(that.naimen) : that.naimen != null) return false;
        if (town != null ? !town.equals(that.town) : that.town != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWh != null ? idWh.hashCode() : 0;
        result = 31 * result + (naimen != null ? naimen.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        return result;
    }
}
