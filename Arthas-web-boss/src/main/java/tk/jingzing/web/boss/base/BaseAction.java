package tk.jingzing.web.boss.base;


import tk.jingzing.facade.entity.PmsUser;
import tk.jingzing.web.common.constant.SessionConstant;
import tk.jingzing.web.common.struts.Struts2ActionSupport;

/**
 * @描述: Web系统权限模块基础支撑Action.
 * Created by wangyunjing on 16/9/4.
 */
@SuppressWarnings("serial")
public class BaseAction extends Struts2ActionSupport implements UserLoginedAware{

    /**
     * 取出当前登录用户对象
     */
    public PmsUser getLoginedUser() {
        PmsUser user = (PmsUser) this.getSessionMap().get(SessionConstant.USER_SESSION_KEY);
        return user;
    }
}
