package cn.zturing.bos.domain;

/**
 * Created by zhoulei on 2018/2/21.
 */
public class BcSubareaEntity {
    private String id;
    private String decidedzoneId;
    private String addresskey;
    private String startnum;
    private String endnum;
    private String single;
    private String position;
    private BcRegionEntity bcRegionByRegionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDecidedzoneId() {
        return decidedzoneId;
    }

    public void setDecidedzoneId(String decidedzoneId) {
        this.decidedzoneId = decidedzoneId;
    }

    public String getAddresskey() {
        return addresskey;
    }

    public void setAddresskey(String addresskey) {
        this.addresskey = addresskey;
    }

    public String getStartnum() {
        return startnum;
    }

    public void setStartnum(String startnum) {
        this.startnum = startnum;
    }

    public String getEndnum() {
        return endnum;
    }

    public void setEndnum(String endnum) {
        this.endnum = endnum;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BcSubareaEntity that = (BcSubareaEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (decidedzoneId != null ? !decidedzoneId.equals(that.decidedzoneId) : that.decidedzoneId != null)
            return false;
        if (addresskey != null ? !addresskey.equals(that.addresskey) : that.addresskey != null) return false;
        if (startnum != null ? !startnum.equals(that.startnum) : that.startnum != null) return false;
        if (endnum != null ? !endnum.equals(that.endnum) : that.endnum != null) return false;
        if (single != null ? !single.equals(that.single) : that.single != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (decidedzoneId != null ? decidedzoneId.hashCode() : 0);
        result = 31 * result + (addresskey != null ? addresskey.hashCode() : 0);
        result = 31 * result + (startnum != null ? startnum.hashCode() : 0);
        result = 31 * result + (endnum != null ? endnum.hashCode() : 0);
        result = 31 * result + (single != null ? single.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    public BcRegionEntity getBcRegionByRegionId() {
        return bcRegionByRegionId;
    }

    public void setBcRegionByRegionId(BcRegionEntity bcRegionByRegionId) {
        this.bcRegionByRegionId = bcRegionByRegionId;
    }
}
