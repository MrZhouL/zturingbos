package cn.zturing.bos.action.bc;

import cn.zturing.bos.action.base.BaseAction;
import cn.zturing.bos.domain.BcRegionEntity;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Created by zhoulei on 2018/2/23.
 */
public class RegionAction extends BaseAction implements ModelDriven<BcRegionEntity>{
    private BcRegionEntity regionEntity = new BcRegionEntity();
    @Override
    public BcRegionEntity getModel() {
        return regionEntity;
    }

    public String save(){
        regionService.save(regionEntity);
        ActionContext.getContext().put("result","success");
        return "save-success";
    }

    @SuppressWarnings("unused")
    public String pagingAndQuery(){
        DetachedCriteria criteria = DetachedCriteria.forClass(BcRegionEntity.class);
        PageRequestBean requestBean = initPageRequestBean(criteria);
        PageResponseBean responseBean = regionService.pageQuery(requestBean);

        ActionContext.getContext().put("result",responseBean);
        return "pagingQuerySuccess";
    }
}
