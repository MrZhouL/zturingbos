package cn.zturing.bos.service;

import cn.zturing.bos.domain.BcStandardEntity;
import cn.zturing.bos.service.base.PageQueryInterface;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;

import java.util.List;

/**
 * Created by zhoulei on 2018/2/19.
 * 取派标准接口
 */
public interface StandardService extends PageQueryInterface{
    void addStandard(BcStandardEntity standardEntity);

    void delectStandard(String standardEntity);

    void updateStandard(BcStandardEntity standardEntity);

    List<BcStandardEntity> getAllStandard();


    /**
     * ajax查询所有正在使用的标准。
     * @return
     */
    List<BcStandardEntity> findAllUse();
}
