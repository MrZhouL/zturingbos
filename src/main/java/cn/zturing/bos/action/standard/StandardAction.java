package cn.zturing.bos.action.standard;

import cn.zturing.bos.action.base.BaseAction;
import cn.zturing.bos.domain.BcStandardEntity;
import cn.zturing.bos.domain.UserEntity;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by zhoulei on 2018/2/19.
 */
public class StandardAction extends BaseAction implements ModelDriven<BcStandardEntity>{

    private BcStandardEntity standardEntity = new BcStandardEntity();

    @Override
    public BcStandardEntity getModel() {
        return standardEntity;
    }

    public String save(){
        //补全数据
        UserEntity loginuser = (UserEntity) getValueFromSession("user");
        standardEntity.setUserByUserId(loginuser);
        standardService.addStandard(standardEntity);

        //返回数据
        //返回客户端json
        ActionContext.getContext().put("result","success");
        return "save_success";
    }

    public String pageQuery(){
        PageRequestBean pageRequestBean = new PageRequestBean();
        pageRequestBean.setPage(page);
        pageRequestBean.setRow(rows);

        DetachedCriteria criteria = DetachedCriteria.forClass(BcStandardEntity.class);
        //显示未删除的标准
        criteria.add(Restrictions.eq("deltag","0"));

        pageRequestBean.setDetachedCriteria(criteria);

        PageResponseBean responseBean =  standardService.pageQuery(pageRequestBean);

        //将结果数据装换为json格式
        ActionContext.getContext().put("result",responseBean);
        return "page-query-success";
    }

    public String delete(){
        standardService.delectStandard(ids);
        ActionContext.getContext().put("result","success");
        return "delete-success";
    }

    private String ids;

    public void setIds(String ids) {
        this.ids = ids;
    }


}
