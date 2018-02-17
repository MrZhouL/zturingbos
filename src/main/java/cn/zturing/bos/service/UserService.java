package cn.zturing.bos.service;

import cn.zturing.bos.domain.UserEntity;

import java.util.List;

/**
 * Created by zhoulei on 2018/2/17.
 */
public interface UserService {
    /**
     * 登录方法
     * @param user
     * @return
     */
    public UserEntity login(UserEntity user);

    /**
     * 修改密码
     * @param userEntity
     */
    void editpassword(UserEntity userEntity);

    /**
     * 添加用户
     * @param userEntity
     */
    void addUser(UserEntity userEntity);

    /**
     * 删除用户
     * @param userEntity
     */
    void delectUser(UserEntity userEntity);

    /**
     * 修改用户
     * @param userEntity
     */
    void updateUser(UserEntity userEntity);

    /**
     * 获取所有用户
     * @return
     */
    List<UserEntity> getAllUser();

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    UserEntity findById(long id);


}
