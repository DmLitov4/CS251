package org;

import javax.persistence.*;

/**
 * Created by rasiel on 16.04.16.
 */
@Entity
@Table(name = "AGENT", schema = "", catalog = "")
public class AgentEntity {
    private int idAgent;
    private String name;
    private String town;
    private String phone;
    private Integer idSeller;

    @Id
    @Column(name = "ID_AGENT")
    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
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

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "ID_SELLER")
    public Integer getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(Integer idSeller) {
        this.idSeller = idSeller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgentEntity that = (AgentEntity) o;

        if (idAgent != that.idAgent) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (town != null ? !town.equals(that.town) : that.town != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (idSeller != null ? !idSeller.equals(that.idSeller) : that.idSeller != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAgent;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (idSeller != null ? idSeller.hashCode() : 0);
        return result;
    }
}
