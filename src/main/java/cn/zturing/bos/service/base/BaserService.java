package cn.zturing.bos.service.base;

import cn.zturing.bos.dao.GenericDao;
import cn.zturing.bos.domain.UserEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhoulei on 2018/2/17.
 */
@Transactional
public abstract class BaserService {
    protected GenericDao<UserEntity> userDao;

    public void setUserDao(GenericDao<UserEntity> userDao) {
        this.userDao = userDao;
    }
}
