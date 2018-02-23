package cn.zturing.bos.action.user;

import cn.zturing.bos.action.base.BaseAction;
import cn.zturing.bos.domain.UserEntity;
import cn.zturing.bos.utils.MD5Utils;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Created by zhoulei on 2018/2/17.
 */
public class UserAction extends BaseAction implements ModelDriven<UserEntity>{
    private UserEntity userEntity = new UserEntity();

    public UserEntity getModel() {
        return userEntity;
    }


    /**
     * 业务方法，修改密码
     * @return
     */
    public String editpassword(){
        //登录的用户
        UserEntity loginUser = (UserEntity) getValueFromSession("user");
        userEntity.setId(loginUser.getId());
        userService.editpassword(userEntity);

        //返回客户端json
        ActionContext.getContext().put("result","success");
        return "editpasswordSUCCESS";
    }

    /**
     * 添加用户
     * @return
     */
    public String add(){
        //将密码md5
        userEntity.setPassword(MD5Utils.md5(userEntity.getPassword()));
        userService.addUser(userEntity);
        return "addsuccess";
    }

    public String pageQuery(){
        DetachedCriteria criteria = DetachedCriteria.forClass(UserEntity.class);
        PageRequestBean pageRequestBean = initPageRequestBean(criteria);
        PageResponseBean responseBean = userService.pageQuery(pageRequestBean);
        ActionContext.getContext().put("result",responseBean);
        return "pageQuerySuccess";
    }


}
