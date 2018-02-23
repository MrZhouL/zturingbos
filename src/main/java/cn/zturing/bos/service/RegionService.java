package cn.zturing.bos.service;

import cn.zturing.bos.domain.BcRegionEntity;
import cn.zturing.bos.service.base.PageQueryInterface;

/**
 * Created by zhoulei on 2018/2/23.
 */
public interface RegionService extends PageQueryInterface{
    void save(BcRegionEntity regionEntity);
}
