package com.earl.fishshop.domain.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.domain.base.BaseDaoImpl;
import com.earl.fishshop.util.MyConstant;


/**
 * 
 * @author 宋文光
 *
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserPo> implements UserDao {
	
	/**
	 * 通过手机号码查询用户.
	 * @author 宋文光
	 * @param phoneNumber
	 * @return
	 */
	public UserPo getUserByPhone(String phoneNumber){
		String hql = "from UserPo u where u.phoneNumber = :phoneNumber";
		UserPo user = (UserPo) getCurrentSession().createQuery(hql)
				.setString("phoneNumber", phoneNumber).uniqueResult();
		return user;
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

	/**
	 * 获取所有渔户的用户信息.
	 * @author 宋文光
	 */
	@SuppressWarnings("unchecked")
	public List<UserPo> getAllFishmanUser() {
		String hql = "from UserPo u where u.userType = :userType";
		List<UserPo> list = getCurrentSession().createQuery(hql)
				.setInteger("userType", MyConstant.user_fishman).list();
		return list;
	}
	
	/**
	 * 获取所有养殖户的用户信息.
	 * @author 宋文光
	 */
	@SuppressWarnings("unchecked")
	public List<UserPo> getAllFarmersUser() {
		String hql = "from UserPo u where u.userType = :userType";
		List<UserPo> list = getCurrentSession().createQuery(hql)
				.setInteger("userType", MyConstant.user_farmer).list();
		return list;
	}

	@Override
	public Boolean blackUser(UserPo model) {
		String hql = "update UserPo set state=:state where identityId = :identityId and userType = :userType";
		int a = getCurrentSession().createQuery(hql)
			.setInteger("state", MyConstant.user_black)
			.setInteger("userType", model.getUserType())
			.setLong("identityId", model.getIdentityId()).executeUpdate();
		if(a == 1) return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserPo> findAllUser() {
		String hql = "from UserPo u order by u.createTime desc";
		List<UserPo> userlist = getCurrentSession().createQuery(hql).list();
		return userlist;
	}

}