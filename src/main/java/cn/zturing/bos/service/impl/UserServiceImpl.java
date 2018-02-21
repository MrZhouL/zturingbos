package cn.zturing.bos.service.impl;

import cn.zturing.bos.domain.BcStandardEntity;
import cn.zturing.bos.domain.UserEntity;
import cn.zturing.bos.service.UserService;
import cn.zturing.bos.service.base.BaserService;
import cn.zturing.bos.utils.MD5Utils;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;

import java.util.List;

/**
 * Created by zhoulei on 2018/2/17.
 */
public class UserServiceImpl extends BaserService implements UserService{
    public UserEntity login(UserEntity user) {
        List<UserEntity> userEntityList = userDao.findByNamedQuery("user.login", user.getUsername(), MD5Utils.md5(user.getPassword()));
        return userEntityList.isEmpty()?null:userEntityList.get(0);
    }

    public void editpassword(UserEntity userEntity) {
        UserEntity entity = userDao.findById(userEntity.getId());
        entity.setPassword(MD5Utils.md5(userEntity.getPassword()));
    }

    public void addUser(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    public void delectUser(UserEntity userEntity) {
        userDao.delete(userEntity);
    }

    public void updateUser(UserEntity userEntity) {
        userDao.update(userEntity);
    }

    public List<UserEntity> getAllUser() {
        return userDao.findAll();
    }

    public UserEntity findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
        PageResponseBean resoule = new PageResponseBean();

        List<BcStandardEntity> list = userDao.pageQuery(pageRequestBean.getDetachedCriteria(), pageRequestBean.getFirstResult(), pageRequestBean.getRow());
        long totalCount = userDao.findTotalCount(pageRequestBean.getDetachedCriteria());

        resoule.setRows(list);
        resoule.setTotal(totalCount);

        return resoule;
    }


}
