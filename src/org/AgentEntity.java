package org;

import javax.persistence.*;

/**
 * Created by rasiel on 13.04.16.
 */
@Entity
@Table(name = "AGENT", schema = "", catalog = "")
public class AgentEntity {
    private String idAg;
    private String nameAg;
    private String town;
    private String phone;

    @Id
    @Column(name = "ID_AG")
    public String getIdAg() {
        return idAg;
    }

    public void setIdAg(String idAg) {
        this.idAg = idAg;
    }

    @Basic
    @Column(name = "NAME_AG")
    public String getNameAg() {
        return nameAg;
    }

    public void setNameAg(String nameAg) {
        this.nameAg = nameAg;
    }

    @Basic
    @Column(name = "TOWN")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgentEntity that = (AgentEntity) o;

        if (idAg != null ? !idAg.equals(that.idAg) : that.idAg != null) return false;
        if (nameAg != null ? !nameAg.equals(that.nameAg) : that.nameAg != null) return false;
        if (town != null ? !town.equals(that.town) : that.town != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAg != null ? idAg.hashCode() : 0;
        result = 31 * result + (nameAg != null ? nameAg.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
