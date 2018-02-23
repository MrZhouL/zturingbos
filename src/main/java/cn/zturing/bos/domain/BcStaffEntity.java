package cn.zturing.bos.domain;

import java.util.Collection;

/**
 * Created by zhoulei on 2018/2/21.
 */
public class BcStaffEntity {
    private String id; //id 使用assigned策略
    private String name;
    private String telephone;
    private String haspda = "0";//是否有pda，默认没有，1有 0 没有
    private String deltag = "0";// 删除标记 （真实系统，数据不能完全删除 ） ， 1 删除  0 未删除
    private String station;
    private Collection<BcDecidedzoneEntity> bcDecidedzonesById;
    private BcStandardEntity bcStandardByStandardId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHaspda() {
        return haspda;
    }

    public void setHaspda(String haspda) {
        this.haspda = haspda;
    }

    public String getDeltag() {
        return deltag;
    }

    public void setDeltag(String deltag) {
        this.deltag = deltag;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BcStaffEntity that = (BcStaffEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (haspda != null ? !haspda.equals(that.haspda) : that.haspda != null) return false;
        if (deltag != null ? !deltag.equals(that.deltag) : that.deltag != null) return false;
        if (station != null ? !station.equals(that.station) : that.station != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (haspda != null ? haspda.hashCode() : 0);
        result = 31 * result + (deltag != null ? deltag.hashCode() : 0);
        result = 31 * result + (station != null ? station.hashCode() : 0);
        return result;
    }

    public Collection<BcDecidedzoneEntity> getBcDecidedzonesById() {
        return bcDecidedzonesById;
    }

    public void setBcDecidedzonesById(Collection<BcDecidedzoneEntity> bcDecidedzonesById) {
        this.bcDecidedzonesById = bcDecidedzonesById;
    }

    public BcStandardEntity getBcStandardByStandardId() {
        return bcStandardByStandardId;
    }

    public void setBcStandardByStandardId(BcStandardEntity bcStandardByStandardId) {
        this.bcStandardByStandardId = bcStandardByStandardId;
    }
}
