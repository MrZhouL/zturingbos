package cn.zturing.bos.dao;

import org.hibernate.criterion.DetachedCriteria;
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
}
