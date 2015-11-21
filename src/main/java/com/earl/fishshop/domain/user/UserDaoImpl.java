package com.earl.fishshop.domain.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.base.BaseDaoImpl;
import com.earl.fishshop.pojo.UserPo;
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
	public Boolean blackUser(Long identityId) {
		//TODO 不知道executeUpdate()返回值是啥
		Boolean result = true;
		String hql = "update UserPo set state=:state where identityId = :identityId";
		getCurrentSession().createQuery(hql)
			.setInteger("state", MyConstant.user_black)
			.setLong("identityId", identityId).executeUpdate();
		return result;
	}

}