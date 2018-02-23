package cn.zturing.bos.service.impl;

import cn.zturing.bos.domain.BcRegionEntity;
import cn.zturing.bos.service.RegionService;
import cn.zturing.bos.service.base.BaserService;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;

/**
 * Created by zhoulei on 2018/2/23.
 */
public class RegionServiceImpl extends BaserService implements RegionService{
    @Override
    public void save(BcRegionEntity regionEntity) {
        regionDao.save(regionEntity);
    }

    @Override
    public PageResponseBean pageQuery(PageRequestBean requestBean) {
        return genericPageQueryImpl(requestBean,regionDao);
    }
}
