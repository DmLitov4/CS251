package org;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by rasiel on 11.05.16.
 */
@Entity
@Table(name = "SELLER", schema = "", catalog = "")
public class SellerEntity {
    private int idSeller;
    private String name;
    private Date bonusLastTimeUpdated;
    private double bonusSize;

    @Id
    @Column(name = "ID_SELLER")
    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
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
    @Column(name = "BONUS_LAST_TIME_UPDATED")
    public Date getBonusLastTimeUpdated() {
        return bonusLastTimeUpdated;
    }

    public void setBonusLastTimeUpdated(Date bonusLastTimeUpdated) {
        this.bonusLastTimeUpdated = bonusLastTimeUpdated;
    }

    @Basic
    @Column(name = "BONUS_SIZE")
    public double getBonusSize() {
        return bonusSize;
    }

    public void setBonusSize(double bonusSize) {
        this.bonusSize = bonusSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellerEntity that = (SellerEntity) o;

        if (idSeller != that.idSeller) return false;
        if (Double.compare(that.bonusSize, bonusSize) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (bonusLastTimeUpdated != null ? !bonusLastTimeUpdated.equals(that.bonusLastTimeUpdated) : that.bonusLastTimeUpdated != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idSeller;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (bonusLastTimeUpdated != null ? bonusLastTimeUpdated.hashCode() : 0);
        temp = Double.doubleToLongBits(bonusSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
