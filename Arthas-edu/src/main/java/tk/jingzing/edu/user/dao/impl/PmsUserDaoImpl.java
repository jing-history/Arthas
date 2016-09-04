package tk.jingzing.edu.user.dao.impl;

import org.springframework.stereotype.Repository;
import tk.jingzing.edu.common.core.dao.BaseDaoImpl;
import tk.jingzing.edu.user.dao.PmsUserDao;
import tk.jingzing.edu.user.entity.PmsUser;


/**
 * 
 * @描述: 用户表数据访问层接口实现类.
 * @作者: WuShuicheng .
 * @创建时间: 2013-7-22,下午5:51:47 .
 * @版本: 1.0 .
 */
@Repository("pmsUserDao")
public class PmsUserDaoImpl extends BaseDaoImpl<PmsUser> implements PmsUserDao {

	/**
	 * 根据用户登录名获取用户信息.
	 * 
	 * @param userNo
	 *            .
	 * @return user .
	 */

	public PmsUser findByUserNo(String userNo) {
		return super.getSqlSession().selectOne(getStatement("findByUserNo"), userNo);
	}

}
