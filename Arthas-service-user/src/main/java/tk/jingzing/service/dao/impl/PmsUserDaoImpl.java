package tk.jingzing.service.dao.impl;

import org.springframework.stereotype.Repository;
import tk.jingzing.common.core.dao.BaseDaoImpl;
import tk.jingzing.common.page.PageBean;
import tk.jingzing.common.page.PageParam;
import tk.jingzing.facade.entity.PmsUser;
import tk.jingzing.service.dao.PmsUserDao;

import java.util.Map;


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

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return null;
	}
}
