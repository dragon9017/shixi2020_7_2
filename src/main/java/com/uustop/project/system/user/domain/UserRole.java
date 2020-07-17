package com.uustop.project.system.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户和角色关联 sys_user_role
 * 
 * @author uustop
 */
public class UserRole
{
    /** 用户ID */
    private Long userId;

    private long s_user_id;

    public UserRole(Long userId) {
        this.userId = userId;
    }

    public long getS_user_id() {
        return s_user_id;
    }

    public void setS_user_id(long s_user_id) {
        this.s_user_id = s_user_id;
    }

    /** 角色ID */
    private Long roleId;

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", s_user_id=" + s_user_id +
                ", roleId=" + roleId +
                '}';
    }

    public UserRole(Long userId, long s_user_id, Long roleId) {
        this.userId = userId;
        this.s_user_id = s_user_id;
        this.roleId = roleId;
    }
    public UserRole() {
    }
}
