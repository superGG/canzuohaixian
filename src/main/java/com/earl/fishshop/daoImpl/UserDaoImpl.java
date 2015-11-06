package com.earl.fishshop.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.UserDao;
import com.earl.fishshop.pojo.UserPo;


/**
 * 
 * @author 宋文光
 *
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserPo> implements UserDao {
	// property constants
	
	//事例方法
	@SuppressWarnings("rawtypes")
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
	
	/**
	 * 通过手机号码查询用户.
	 * @author 宋文光
	 * @param phoneNumber
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserPo> getUserByPhone(String phoneNumber){
		String hql = "from UserPo u where u.phoneNumber = :phoneNumber";
		List<UserPo> list = getCurrentSession().createQuery(hql)
				.setString("phoneNumber", phoneNumber).list();
		return list;
	}

	/**
	 * 通过用户名查询用户.
	 * @author 宋文光
	 * @param userName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserPo> getUserByName(String userName) {
		String hql = "from UserPo u where u.userName = :userName";
		List<UserPo> list = getCurrentSession().createQuery(hql)
				.setString("userName", userName).list();
		return list;
	}

}