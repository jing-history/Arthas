package tk.jingzing.edu.user.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import tk.jingzing.edu.user.base.BaseAction;
import tk.jingzing.edu.user.biz.PmsUserBiz;

/**
 * @描述: 用户信息管理 .
 * Created by wangyunjing on 16/9/4.
 */
@Scope("prototype")
public class PmsUserAction extends BaseAction {

    private static Log log = LogFactory.getLog(PmsUserAction.class);

    @Autowired
    private PmsUserBiz pmsUserBiz;


}
