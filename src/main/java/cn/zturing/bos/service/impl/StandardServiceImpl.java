package cn.zturing.bos.service.impl;

import cn.zturing.bos.domain.BcStandardEntity;
import cn.zturing.bos.service.StandardService;
import cn.zturing.bos.service.base.BaserService;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;

import java.util.List;

/**
 * Created by zhoulei on 2018/2/19.
 */
public class StandardServiceImpl extends BaserService implements StandardService{

    @Override
    public void addStandard(BcStandardEntity standardEntity) {
        if (standardEntity.getId() != null && standardEntity.getId().trim().length()>0){
            //有id 修改
            standardGenericDao.update(standardEntity);
        }else {
            standardGenericDao.save(standardEntity);
        }
    }

    @Override
    public void delectStandard(String standardEntity) {
        //standardGenericDao.delete(standardEntity);
        //不是真删，把deltag设置为1
        String[] ids = standardEntity.split(",");
        for (String id:ids) {
            BcStandardEntity entity = standardGenericDao.findById(id);
            entity.setDeltag("1");
        }
    }

    @Override
    public void updateStandard(BcStandardEntity standardEntity) {
        standardGenericDao.update(standardEntity);
    }

    @Override
    public List<BcStandardEntity> getAllStandard() {
        return standardGenericDao.findAll();
    }

    @Override
    public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
        PageResponseBean responseBean = new PageResponseBean();

        //这里需修改下GenericDao,涉及QBC投影查询，必须先查询row 在查询total
        List<BcStandardEntity> list = standardGenericDao.pageQuery(pageRequestBean.getDetachedCriteria(),pageRequestBean.getFirstResult(),pageRequestBean.getRow());

        responseBean.setRows(list);

        //查询总记录数
        long totalnum = standardGenericDao.findTotalCount(pageRequestBean.getDetachedCriteria());

        responseBean.setTotal(totalnum);
        return responseBean;
    }
}
