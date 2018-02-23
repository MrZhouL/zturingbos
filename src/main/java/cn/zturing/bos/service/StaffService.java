package cn.zturing.bos.service;

import cn.zturing.bos.domain.BcStaffEntity;
import cn.zturing.bos.service.base.PageQueryInterface;

/**
 * Created by zhoulei on 2018/2/23.
 */
public interface StaffService extends PageQueryInterface{
    void save(BcStaffEntity staffEntity);

}
