package tk.jingzing.edu.user.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import tk.jingzing.edu.common.page.PageBean;
import tk.jingzing.edu.user.base.BaseAction;
import tk.jingzing.edu.user.biz.PmsUserBiz;
import tk.jingzing.edu.user.entity.PmsUser;
import tk.jingzing.edu.user.enums.UserStatusEnum;
import tk.jingzing.edu.user.enums.UserTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @描述: 用户信息管理 .
 * Created by wangyunjing on 16/9/4.
 */
@Scope("prototype")
public class PmsUserAction extends BaseAction {

    private static Log log = LogFactory.getLog(PmsUserAction.class);

    @Autowired
    private PmsUserBiz pmsUserBiz;

    // /////////////////////////////////// 用户管理   //////////////////////////////////////////
    /**
     * 分页列出用户信息，并可按登录名获姓名进行查询.
     *
     * @return listPmsUser or operateError .
     *
     */
    public String listPmsUser() {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
            paramMap.put("userNo", getString("userNo")); // 用户登录名（精确查询）
            paramMap.put("userName", getString("userName")); // 用户姓名（模糊查询）
            paramMap.put("status", getInteger("status")); // 状态

            PageBean pageBean = pmsUserBiz.listPage(getPageParam(), paramMap);
            this.pushData(pageBean);
            PmsUser pmsUser = getLoginedUser();// 获取当前登录用户对象
            this.putData("currUserNo", pmsUser.getUserNo());
            // 回显查询条件值
            this.pushData(paramMap);

            this.putData("UserStatusEnumList", UserStatusEnum.values());
            this.putData("UserStatusEnum", UserStatusEnum.toMap());
            this.putData("UserTypeEnumList", UserTypeEnum.values());
            this.putData("UserTypeEnum", UserTypeEnum.toMap());

            return "PmsUserList";
        } catch (Exception e) {
            log.error("== listPmsUser exception:", e);
            return operateError("获取数据失败");
        }
    }
}
