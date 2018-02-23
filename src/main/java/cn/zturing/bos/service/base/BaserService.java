package cn.zturing.bos.service.base;

import cn.zturing.bos.dao.GenericDao;
import cn.zturing.bos.domain.BcRegionEntity;
import cn.zturing.bos.domain.BcStaffEntity;
import cn.zturing.bos.domain.BcStandardEntity;
import cn.zturing.bos.domain.UserEntity;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 抽象类，主要用来集成公共方法
 * Created by zhoulei on 2018/2/17.
 */
@Transactional
public abstract class BaserService {
    protected GenericDao<UserEntity> userDao;

    public void setUserDao(GenericDao<UserEntity> userDao) {
        this.userDao = userDao;
    }

    protected GenericDao<BcStandardEntity> standardGenericDao;

    public void setStandardGenericDao(GenericDao<BcStandardEntity> standardGenericDao) {
        this.standardGenericDao = standardGenericDao;
    }

    protected GenericDao<BcStaffEntity> staffDao;

    public void setStaffDao(GenericDao<BcStaffEntity> staffDao) {
        this.staffDao = staffDao;
    }

    protected GenericDao<BcRegionEntity> regionDao;

    public void setRegionDao(GenericDao<BcRegionEntity> regionDao) {
        this.regionDao = regionDao;
    }

    /**
     * 公用分页方法
     * @param requestBean
     * @param genericDao
     * @param <T>
     * @return
     */
    public <T> PageResponseBean genericPageQueryImpl(PageRequestBean requestBean,GenericDao<T> genericDao){
        PageResponseBean responseBean = new PageResponseBean();

        List<T> list = genericDao.pageQuery(requestBean.getDetachedCriteria(), requestBean.getFirstResult(), requestBean.getRow());

        long count = genericDao.findTotalCount(requestBean.getDetachedCriteria());

        responseBean.setTotal(count);
        responseBean.setRows(list);
        return responseBean;
    }
}
