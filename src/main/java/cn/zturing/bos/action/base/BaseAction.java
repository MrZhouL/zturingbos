package cn.zturing.bos.action.base;

import cn.zturing.bos.service.StandardService;
import cn.zturing.bos.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by zhoulei on 2018/2/17.
 */
public abstract class BaseAction extends ActionSupport{
    //注入service

    //用户管理service
    protected UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //标准管理service
    protected StandardService standardService;

    public void setStandardService(StandardService standardService) {
        this.standardService = standardService;
    }

    // 简化 Web对象获取
    public HttpSession getSession(){
        return ServletActionContext.getRequest().getSession();
    }
    public Object getValueFromSession(String name){
        return ServletActionContext.getRequest().getSession().getAttribute(name);
    }

    //使用属性驱动，获取分页查询参数.
    protected int page;
    protected int rows;

    public void setPage(int page) {
        this.page = page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
