package cn.zturing.bos.dao;

import cn.zturing.bos.domain.BcStandardEntity;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhoulei on 2018/2/15.
 * 通用dao接口
 */
public interface GenericDao<T> {
    /**
     * 保存数据
     * @param obje
     */
    public void save(T obje);

    /**
     * 修改数据
     * @param obje
     */
    public  void update(T obje);

    /**
     * 删除数据
     * @param obje
     */
    public void delete(T obje);

    /**
     * 根据id查询（hibernate的所有po类型主键必须实现serializeble接口）
     * @param id
     * @return
     */
    public T findById(Serializable id);

    /**
     * 查询所以
     * @return
     */
    public List<T> findAll();

    /**
     * 条件查询数据(根据离线条件对象DatachedCriteria)
     * @param criteria
     * @return
     */
    public List<T> findByCriteria(DetachedCriteria criteria);

    /**
     *条件查询 （根据hql）
     * @param queryName
     * @param values
     * @return
     */
    public  List<T> findByNamedQuery(String queryName, Object... values);

    /**
     * 分页查询
     * @param detachedCriteria 条件
     * @param firstResult   起始记录索引
     * @param maxResults    显示多少条记录
     * @return
     */
    List<BcStandardEntity> pageQuery(DetachedCriteria detachedCriteria,int firstResult,int maxResults);

    /**
     * 分页查询-查询总记录数
     * @param criteria
     * @return
     */
    long findTotalCount(DetachedCriteria criteria);
}
