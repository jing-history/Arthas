package tk.jingzing.facade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jingzing.facade.common.page.PageBean;
import tk.jingzing.facade.common.page.PageParam;
import tk.jingzing.facade.entity.PmsUser;
import tk.jingzing.facade.service.PmsUserFacade;
import tk.jingzing.service.biz.PmsUserBiz;

import java.util.Map;

/**
 * @Description:用户Dubbo服务接口 实现
 * Created by Louis Wang on 2016/9/6.
 */
@Service("pmsUserFacade")
public class PmsUserFacadeImpl implements PmsUserFacade{

    @Autowired
    private PmsUserBiz pmsUserBiz;

    /**
     * 保存用户信息.
     * @param pmsUser
     */
    public void create(PmsUser pmsUser) {
        pmsUserBiz.create(pmsUser);
    }

    /**
     * 根据ID获取用户信息.
     * @param userId
     * @return
     */
    public PmsUser getById(Long userId) {
        return pmsUserBiz.getById(userId);
    }

    /**
     * 根据登录名取得用户对象
     */
    public PmsUser findUserByUserNo(String userNo) {
        return pmsUserBiz.findUserByUserNo(userNo);
    }

    /**
     * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
     *
     * @param userId
     *            用户ID.
     */
    public void deleteUserById(long userId) {
        PmsUser pmsUser = pmsUserBiz.getById(userId);
        if (pmsUser != null) {
            if ("1".equals(pmsUser.getUserType())) {
                throw new RuntimeException("【" + pmsUser.getUserNo() + "】为超级管理员，不能删除！");
            }
            pmsUserBiz.deleteUserById(pmsUser.getId());
        }
    }


    /**
     * 更新用户信息.
     * @param user
     */
    public void update(PmsUser user) {
        pmsUserBiz.update(user);
    }

    /**
     * 根据用户ID更新用户密码.
     *
     * @param userId
     * @param newPwd
     *            (已进行SHA1加密)
     */
    public void updateUserPwd(Long userId, String newPwd, boolean isTrue) {
        PmsUser pmsUser = pmsUserBiz.getById(userId);
        pmsUser.setUserPwd(newPwd);
        pmsUser.setPwdErrorCount(0); // 密码错误次数重置为0
        pmsUser.setIsChangedPwd(isTrue); // 设置密码为已修改过
        pmsUserBiz.update(pmsUser);
    }



    /**
     * 查询并分页列出用户信息.
     * @param pageParam
     * @param paramMap
     * @return
     */
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return pmsUserBiz.listPage(pageParam, paramMap);
    }
}
