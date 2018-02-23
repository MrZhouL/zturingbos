package cn.zturing.bos.action.bc;

import cn.zturing.bos.action.base.BaseAction;
import cn.zturing.bos.domain.BcStaffEntity;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by zhoulei on 2018/2/23.
 */
public class StaffAction extends BaseAction implements ModelDriven<BcStaffEntity>{
    private BcStaffEntity entity = new BcStaffEntity();
    @Override
    public BcStaffEntity getModel() {
        return entity;
    }

    public String save(){
        staffService.save(entity);
        ActionContext.getContext().put("result","success");
        return "save-success";
    }

    @SuppressWarnings("unused")
    public String pageQuery(){

        DetachedCriteria criteria = DetachedCriteria.forClass(BcStaffEntity.class);
        //criteria.add(Restrictions.eq("deltag","0"));
        PageRequestBean pageRequestBean = initPageRequestBean(criteria);
        PageResponseBean responseBean = staffService.pageQuery(pageRequestBean);
        ActionContext.getContext().put("pageList",responseBean);
        return "pageQuerySuccess";
    }
}
