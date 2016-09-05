package tk.jingzing.facade.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @描述: 基础实体类，包含各实体公用属性 .
 * Created by wangyunjing on 16/9/4.
 */
public class BaseEntity implements Serializable{

    /** 主键ID **/
    private Long id;

    /** 版本号 **/
    private Integer version = 0;

    /** 创建时间 **/
    private Date createTime;

    /** 主键ID **/
    public Long getId() {
        return id;
    }

    /** 主键ID **/
    public void setId(Long id) {
        this.id = id;
    }

    /** 版本号 **/
    public Integer getVersion() {
        return version;
    }

    /** 版本号 **/
    public void setVersion(Integer version) {
        this.version = version;
    }

    /** 创建时间 **/
    public Date getCreateTime() {
        return createTime;
    }

    /** 创建时间 **/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
