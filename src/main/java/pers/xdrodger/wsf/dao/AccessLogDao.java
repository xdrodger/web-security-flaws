package pers.xdrodger.wsf.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.xdrodger.wsf.entity.AccessLog;

/**
 * 访问日志dao
 * 
 * @author xudongdong
 *         2015年12月12日 下午9:54:41
 */
@Repository
public class AccessLogDao extends SimpleHibernateDao<AccessLog, String> {
    
	@Autowired
    private SessionFactory sessionFactory;
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
      
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public void add(AccessLog entity) {
		String sql = "insert into access_log (id,info,create_time) "
				+ "values(?,?,?)";
//        Session session = sessionFactory.getCurrentSession();
//        Query q = session.createSQLQuery(sql);
		Query q = getSession().createSQLQuery(sql);
        q.setString(0, entity.getId());
        q.setString(1, entity.getInfo());
        q.setTimestamp(2, entity.getCreateTime());
        int res = q.executeUpdate();
        System.out.println(res);
    }
    
    public List<AccessLog> getAll(){
        String hsql="from AccessLog";
        Query query = getSession().createQuery(hsql);
        return query.list();
    }
}