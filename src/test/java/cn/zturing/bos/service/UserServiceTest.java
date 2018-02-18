package cn.zturing.bos.service;

import cn.zturing.bos.domain.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhoulei on 2018/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {
    @Test
    public void findById() throws Exception {
        UserEntity entity = userService.findById(2);
        System.out.println(entity);
    }

    @Test
    public void addUser() throws Exception {
        UserEntity addUser = new UserEntity();
        addUser.setUsername("zhangsan");
        addUser.setPassword("admin");

        userService.addUser(addUser);

    }

    @Test
    public void delectUser() throws Exception {

    }

    @Test
    public void updateUser() throws Exception {
        UserEntity entity = userService.findById(2);
        entity.setRemark("土豪用户");

        userService.updateUser(entity);
        UserEntity u = userService.findById(2);
        System.out.println(u);
    }

    @Test
    public void getAllUser() throws Exception {
        List<UserEntity> allUser = userService.getAllUser();

        System.out.println(allUser);
    }

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Test
    public void login() throws Exception {
        UserEntity user = new UserEntity();
        user.setUsername("admin");
        user.setPassword("admin");

        UserEntity login = userService.login(user);
        System.out.println("用户名："+login.getUsername()+"密码："+login.getPassword());
    }

    @Test
    public void editpassword() throws Exception {
        UserEntity updateUserPassword = new UserEntity();
        updateUserPassword.setId(3);
        updateUserPassword.setPassword("123");

        userService.editpassword(updateUserPassword);
    }



}