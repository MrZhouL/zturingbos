package cn.zturing.bos.interceptor;

import cn.zturing.bos.domain.UserEntity;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * 登录拦截器
 * Created by zhoulei on 2018/2/18.
 */
public class LoginInterceptor extends AbstractInterceptor{

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //判断session里是否有user
        UserEntity loginUser = (UserEntity) ServletActionContext.getRequest().getSession().getAttribute("user");

        if (loginUser == null) {
            //保存错误信息。
            ActionSupport action = (ActionSupport) actionInvocation.getAction();
            action.addActionError(action.getText("nologin"));
            return "login";
        }else {
            return actionInvocation.invoke();
        }
    }
}
