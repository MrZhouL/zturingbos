package cn.zturing.bos.action;

import cn.zturing.bos.action.base.BaseAction;
import cn.zturing.bos.domain.UserEntity;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * Created by zhoulei on 2018/2/17.
 */
public class LoginAction extends BaseAction implements ModelDriven<UserEntity>{

    private UserEntity user = new UserEntity();

    public UserEntity getModel() {
        return user;
    }

    //验证吗
    private String checkcode;

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public String login(){
        //判断验证码是否正确
        String key = (String) getValueFromSession("key");
        if (key == null || !key.equals(checkcode)){
            this.addFieldError("checkcode", this.getText("checkcodefail"));
            return INPUT;
        }

        UserEntity userEntity = userService.login(user);
        if (userEntity == null) {
            this.addActionError(this.getText("loginfail"));
            return INPUT;
        }else {
            getSession().setAttribute("user",userEntity);
            return SUCCESS;
        }
    }
}
