package com.jackson.druid.dao;

import com.jackson.druid.domain.entity.SysRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SysRoleMapper {
    @Delete({
        "delete from sys_role",
        "where ROLE_ID = #{roleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long roleId);

    @Insert({
        "insert into sys_role (ROLE_ID, ROLE_NAME, ",
        "ROLE_CODE, ROLE_DESC, ",
        "STATUS, LAST_MODIFY_BY, ",
        "LAST_MODIFY_DATE, CREATE_BY, ",
        "CREATE_DATE, REMARK)",
        "values (#{roleId,jdbcType=BIGINT}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleCode,jdbcType=VARCHAR}, #{roleDesc,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{lastModifyBy,jdbcType=VARCHAR}, ",
        "#{lastModifyDate,jdbcType=TIMESTAMP}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(SysRole record);

    @InsertProvider(type=SysRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysRole record);

    @Select({
        "select",
        "ROLE_ID, ROLE_NAME, ROLE_CODE, ROLE_DESC, STATUS, LAST_MODIFY_BY, LAST_MODIFY_DATE, ",
        "CREATE_BY, CREATE_DATE, REMARK",
        "from sys_role",
        "where ROLE_ID = #{roleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_DESC", property="roleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="LAST_MODIFY_BY", property="lastModifyBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_MODIFY_DATE", property="lastModifyDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_BY", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    SysRole selectByPrimaryKey(Long roleId);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysRole record);

    @Update({
        "update sys_role",
        "set ROLE_NAME = #{roleName,jdbcType=VARCHAR},",
          "ROLE_CODE = #{roleCode,jdbcType=VARCHAR},",
          "ROLE_DESC = #{roleDesc,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=INTEGER},",
          "LAST_MODIFY_BY = #{lastModifyBy,jdbcType=VARCHAR},",
          "LAST_MODIFY_DATE = #{lastModifyDate,jdbcType=TIMESTAMP},",
          "CREATE_BY = #{createBy,jdbcType=VARCHAR},",
          "CREATE_DATE = #{createDate,jdbcType=TIMESTAMP},",
          "REMARK = #{remark,jdbcType=VARCHAR}",
        "where ROLE_ID = #{roleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysRole record);
}