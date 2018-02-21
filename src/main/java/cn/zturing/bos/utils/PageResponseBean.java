package cn.zturing.bos.utils;

import java.util.List;

/**
 * 通用分页请求响应bean
 * Created by zhoulei on 2018/2/21.
 */
public class PageResponseBean {
    //结果数据
    private List rows;
    //总记录数
    private long total;

    public List getRows() {
        return rows;
    }

    public long getTotal() {
        return total;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
