package cn.zturing.bos.service;

import cn.zturing.bos.domain.BcStandardEntity;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;

import java.util.List;

/**
 * Created by zhoulei on 2018/2/19.
 * 取派标准接口
 */
public interface StandardService {
    void addStandard(BcStandardEntity standardEntity);

    void delectStandard(String standardEntity);

    void updateStandard(BcStandardEntity standardEntity);

    List<BcStandardEntity> getAllStandard();

    /**
     * 分页查询
     * @param pageRequestBean
     * @return
     */
    PageResponseBean pageQuery(PageRequestBean pageRequestBean);
}
