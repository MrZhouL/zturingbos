package cn.zturing.bos.utils;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 通用分页查询请求bean
 * Created by zhoulei on 2018/2/21.
 */
public class PageRequestBean {

    //页码
    private int page;
    //每页多少条
    private int row;
    //查询条件
    private DetachedCriteria detachedCriteria;

    //记录索引
    private int firstResult;//从那开始，记录索引

    public int getFirstResult() {
        return (page-1) * row;
    }

    public int getPage() {
        return page;
    }

    public int getRow() {
        return row;
    }

    public DetachedCriteria getDetachedCriteria() {
        return detachedCriteria;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
        this.detachedCriteria = detachedCriteria;
    }
}
