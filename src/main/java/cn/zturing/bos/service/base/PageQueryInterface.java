package cn.zturing.bos.service.base;

import cn.zturing.bos.dao.GenericDao;
import cn.zturing.bos.utils.PageRequestBean;
import cn.zturing.bos.utils.PageResponseBean;

/**
 * Created by zhoulei on 2018/2/23.
 */
public interface PageQueryInterface {
    /**
     * 分页查询接口
     * @param requestBean
     * @return
     */
    PageResponseBean pageQuery(PageRequestBean requestBean);
}
