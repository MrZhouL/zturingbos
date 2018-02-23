package cn.zturing.bos.dao;

import cn.zturing.bos.domain.BcStandardEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhoulei on 2018/2/15.
 */
public class GenericDaoImpl extends HibernateDaoSupport implements GenericDao{

    private String className;

    /**
     * 构造方法是必须加入类名.
     * @param className
     */
    public GenericDaoImpl(String className){
        this.className = className;
    }

    public void save(Object obje) {
        this.getHibernateTemplate().save(obje);
    }

    public void update(Object obje) {
        this.getHibernateTemplate().update(obje);
    }

    public void delete(Object obje) {
        this.getHibernateTemplate().delete(obje);
    }

    public Object findById(Serializable id) {
        try {
            return this.getHibernateTemplate().get(Class.forName(className),id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("实体类名className传入出错！");
        }
    }

    public List findAll() {
        return this.getHibernateTemplate().find("from "+className);
    }

    public List findByCriteria(DetachedCriteria criteria) {
        return this.getHibernateTemplate().findByCriteria(criteria);
    }

    public List findByNamedQuery(String queryName, Object... values) {
        return this.getHibernateTemplate().findByNamedQuery(queryName,values);
    }



    @Override
    public List pageQuery(DetachedCriteria criteria, int firstResult, int maxResults) {
        return this.getHibernateTemplate().findByCriteria(criteria,firstResult,maxResults);
    }

    @Override
    public long findTotalCount(DetachedCriteria criteria) {
        //使用QBC投影查询
        //添加投影效果和sql select count（*） 一样，不加就是 select *
        criteria.setProjection(Projections.rowCount());
        //之前因为调用了pagequery方法，所以first和max Results会保存在criteria里，为了防止报错，只取第一条数据
        List list = this.getHibernateTemplate().findByCriteria(criteria, 0, 1);
        return (Long)list.get(0);

    }
}
