package cn.zturing.bos.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by zhoulei on 2018/2/21.
 */
public class BcStandardEntity implements Serializable{
    private String id;
    private String name;
    private Double minweight;
    private Double maxweight;
    private String deltag = "0";// 删除标记 （真实系统，数据不能完全删除 ） ， 1 删除  0 未删除
    private Timestamp updatetime;
    private Collection<BcStaffEntity> bcStaffsById;
    private UserEntity userByUserId;

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

    public Double getMinweight() {
        return minweight;
    }

    public void setMinweight(Double minweight) {
        this.minweight = minweight;
    }

    public Double getMaxweight() {
        return maxweight;
    }

    public void setMaxweight(Double maxweight) {
        this.maxweight = maxweight;
    }

    public String getDeltag() {
        return deltag;
    }

    public void setDeltag(String deltag) {
        this.deltag = deltag;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BcStandardEntity that = (BcStandardEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (minweight != null ? !minweight.equals(that.minweight) : that.minweight != null) return false;
        if (maxweight != null ? !maxweight.equals(that.maxweight) : that.maxweight != null) return false;
        if (deltag != null ? !deltag.equals(that.deltag) : that.deltag != null) return false;
        if (updatetime != null ? !updatetime.equals(that.updatetime) : that.updatetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (minweight != null ? minweight.hashCode() : 0);
        result = 31 * result + (maxweight != null ? maxweight.hashCode() : 0);
        result = 31 * result + (deltag != null ? deltag.hashCode() : 0);
        result = 31 * result + (updatetime != null ? updatetime.hashCode() : 0);
        return result;
    }

    public Collection<BcStaffEntity> getBcStaffsById() {
        return bcStaffsById;
    }

    public void setBcStaffsById(Collection<BcStaffEntity> bcStaffsById) {
        this.bcStaffsById = bcStaffsById;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
