package cn.zturing.bos.service.impl;

import cn.zturing.bos.dao.GenericDao;
import cn.zturing.bos.domain.BcStaffEntity;
import cn.zturing.bos.domain.BcStandardEntity;
import cn.zturing.bos.service.StaffService;
import cn.zturing.bos.service.base.BaserService;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;

import java.util.List;

/**
 * Created by zhoulei on 2018/2/23.
 */
public class StaffServiceImpl extends BaserService implements StaffService{
    @Override
    public void save(BcStaffEntity staffEntity) {
        staffDao.save(staffEntity);
    }



    @Override
    public PageResponseBean pageQuery(PageRequestBean requestBean) {
        return genericPageQueryImpl(requestBean,staffDao);
    }
}
