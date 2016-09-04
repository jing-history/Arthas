package tk.jingzing.edu.user.base;

import tk.jingzing.edu.common.web.struts.Struts2ActionSupport;
import tk.jingzing.edu.user.entity.PmsUser;

/**
 * @描述: Web系统权限模块基础支撑Action.
 * Created by wangyunjing on 16/9/4.
 */
@SuppressWarnings("serial")
public class BaseAction extends Struts2ActionSupport implements UserLoginedAware{

    public PmsUser getLoginedUser() {
        return null;
    }
}
