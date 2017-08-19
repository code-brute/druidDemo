package com.jackson.druid.dao;

import com.jackson.druid.domain.entity.SysRole;
import org.apache.ibatis.jdbc.SQL;

public class SysRoleSqlProvider {

    public String insertSelective(SysRole record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_role");
        
        if (record.getRoleId() != null) {
            sql.VALUES("ROLE_ID", "#{roleId,jdbcType=BIGINT}");
        }
        
        if (record.getRoleName() != null) {
            sql.VALUES("ROLE_NAME", "#{roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleCode() != null) {
            sql.VALUES("ROLE_CODE", "#{roleCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleDesc() != null) {
            sql.VALUES("ROLE_DESC", "#{roleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("STATUS", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getLastModifyBy() != null) {
            sql.VALUES("LAST_MODIFY_BY", "#{lastModifyBy,jdbcType=VARCHAR}");
        }
        
        if (record.getLastModifyDate() != null) {
            sql.VALUES("LAST_MODIFY_DATE", "#{lastModifyDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("CREATE_BY", "#{createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("CREATE_DATE", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("REMARK", "#{remark,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysRole record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_role");
        
        if (record.getRoleName() != null) {
            sql.SET("ROLE_NAME = #{roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleCode() != null) {
            sql.SET("ROLE_CODE = #{roleCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleDesc() != null) {
            sql.SET("ROLE_DESC = #{roleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("STATUS = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getLastModifyBy() != null) {
            sql.SET("LAST_MODIFY_BY = #{lastModifyBy,jdbcType=VARCHAR}");
        }
        
        if (record.getLastModifyDate() != null) {
            sql.SET("LAST_MODIFY_DATE = #{lastModifyDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("CREATE_BY = #{createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("CREATE_DATE = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("REMARK = #{remark,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("ROLE_ID = #{roleId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}