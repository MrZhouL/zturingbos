package cn.zturing.bos.action.base;

import cn.zturing.bos.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by zhoulei on 2018/2/17.
 */
public abstract class BaseAction {
    //注入service
    protected UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // 简化 Web对象获取
    public HttpSession getSession(){
        return ServletActionContext.getRequest().getSession();
    }
    public Object getValueFromSession(String name){
        return ServletActionContext.getRequest().getSession().getAttribute(name);
    }
}
